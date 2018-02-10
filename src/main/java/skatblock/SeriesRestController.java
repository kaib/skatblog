package skatblock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import skatblock.entitites.Game;
import skatblock.entitites.Series;
import skatblock.exceptions.GameNotFoundException;
import skatblock.exceptions.SeriesNotFoundException;
import skatblock.repositories.GameRepository;
import skatblock.repositories.PlayerRepository;
import skatblock.repositories.SeriesRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/series")
public class SeriesRestController {

  PlayerRepository playerRepository;
  GameRepository gameRepository;
  SeriesRepository seriesRepository;

  @Autowired
  public SeriesRestController(PlayerRepository playerRepository, GameRepository gameRepository,
                              SeriesRepository seriesRepository) {
    this.playerRepository = playerRepository;
    this.gameRepository = gameRepository;
    this.seriesRepository = seriesRepository;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Series> getAllSeries() {
    return seriesRepository.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, path = "/{id}")
  public Series getSeries(@PathVariable Long id) {
    validateSeriesId(id);
    return seriesRepository.findById(id).get();
  }

  @RequestMapping(method = RequestMethod.POST, path = "/{id}/game")
  public ResponseEntity<?> addGame(@PathVariable(name = "id") Long id, @RequestBody Game g) {

    validateSeriesId(id);


    return seriesRepository.findById(id).map(series -> {
      Game result = gameRepository.save(g);
      series.getGames().add(g);
      seriesRepository.save(series);

      URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(
              result.getId()).toUri();
      return ResponseEntity.created(location).build();
    }).orElse(ResponseEntity.noContent().build());
  }

  @RequestMapping(method = RequestMethod.GET, path = "/{id}/game/{gameId}")
  public Game getGame(@PathVariable(name = "id") Long id, @PathVariable(name = "gameId") Long gameId) {
    validateSeriesId(id);
    Series s = seriesRepository.findById(id).get();
    return s.getGameById(gameId);
  }


  private void validateSeriesId(Long id) {
    this.seriesRepository.findById(id).orElseThrow(() -> new SeriesNotFoundException(id));
  }

  private void validateGameId(Long id) {
    this.gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException(id));
  }

}
