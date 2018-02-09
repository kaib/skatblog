package skatblock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {


    @RequestMapping(method= RequestMethod.GET, path = "/user")
    public Player getPlayer(@RequestParam(value="id") long id, @RequestParam(value="name") String name) {
        return new Player(id, name);
    }
}
