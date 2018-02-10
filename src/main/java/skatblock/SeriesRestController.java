package skatblock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import skatblock.entitites.Game;
import skatblock.repositories.GameRepository;
import skatblock.repositories.PlayerRepository;

@RestController
@RequestMapping(path = "/game")
public class GameRestController {

  PlayerRepository playerRepository;
  GameRepository gameRepository;

  @Autowired
  public GameRestController(PlayerRepository playerRepository, GameRepository gameRepository) {
    this.playerRepository = playerRepository;
    this.gameRepository = gameRepository;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<?> addGame(@RequestBody Game g) {
    Game g1 = this.gameRepository.save(g);
    return this.accountRepository.findByUsername(userId).map(account -> {
      Bookmark result = bookmarkRepository.save(new Bookmark(account, input.getUri(), input.getDescription()));

      URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
              result.getId()).toUri();

      return ResponseEntity.created(location).build();
    }).orElse(ResponseEntity.noContent().build());
  }
}
