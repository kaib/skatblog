package skatblock;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  @ManyToMany
  private Set<Game> games = new HashSet<>();

  private Player() {
  }

  public Player(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Game> getGames() {
    return games;
  }

  public void setGames(Set<Game> games) {
    this.games = games;
  }
}
