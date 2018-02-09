package skatblock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class PlayerController {


private final PlayerRepository playerRepository;

@Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Player getPlayer(@RequestParam(value="name") String name) {
        return playerRepository.findByName(name).get();
    }
}
