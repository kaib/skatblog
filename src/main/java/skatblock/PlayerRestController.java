package skatblock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import skatblock.entitites.Player;
import skatblock.repositories.PlayerRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/player")
public class PlayerRestController {


  private final PlayerRepository playerRepository;

  @Autowired
  public PlayerRestController(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Player> getAllPlayers() {
    return playerRepository.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, path = "{name}")
  public Player getPlayer(@PathVariable(value = "name") String name) {
    return playerRepository.findByName(name).get();
  }

}
