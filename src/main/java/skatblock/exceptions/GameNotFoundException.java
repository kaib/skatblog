package skatblock.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class GameNotFoundException extends RuntimeException {

  public GameNotFoundException(Long id) {
    super("Could not find Game with id: " + id + ".");
  }
}
