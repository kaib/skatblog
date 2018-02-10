package skatblock;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Series {

  @Id
  private Long id;

  @OneToMany
  private List<Game> games;

  private Map<Long, Player> positionToPlayer = new HashMap<>();

  private Date date;


}
