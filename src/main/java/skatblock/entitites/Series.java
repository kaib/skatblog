package skatblock.entitites;

import skatblock.exceptions.GameNotFoundException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Series {

  @Id
  private Long id;

  @OneToMany
  private List<Game> games;


  public Series(Long id, List<Game> games) {
    this.id = id;
    this.games = games;
  }

  public Series(Long id) {
    new Series(id, new LinkedList<>());
  }

  private Series() {
    new Series(System.currentTimeMillis());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Game> getGames() {
    return games;
  }

  public void setGames(List<Game> games) {
    this.games = games;
  }

  public Game getGameById(Long gameId) {
    return games.stream().filter(game -> game.getId().equals(gameId)).findFirst().orElseThrow(
            () -> new GameNotFoundException(gameId));
  }
}
