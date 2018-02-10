package skatblock.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class SeriesNotFoundException extends RuntimeException {

  public SeriesNotFoundException(Long id) {
    super("Could not find Game Series with id: " + id + ".");
  }
}
