package skatblock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import skatblock.entitites.Player;
import skatblock.entitites.Series;
import skatblock.repositories.GameRepository;
import skatblock.repositories.PlayerRepository;
import skatblock.repositories.SeriesRepository;

import java.util.Arrays;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  CommandLineRunner init(GameRepository gameRepository, PlayerRepository playerRepository,
                         SeriesRepository seriesRepository) {


    return (evt) -> {
      Arrays.asList("kai,arne,chrissi,borsti".split(",")).forEach(a -> {
        Player player = playerRepository.save(new Player(a));
      });
      Series s = new Series(1L);
      s.setId(1L);
      seriesRepository.save(s);

    };
//    return (evt) -> Arrays.asList("kai,arne,chrissi,borsti".split(",")).forEach(a -> {
//      Player player = playerRepository.save(new Player(a));
//      Game g = new Game(GAME_TYPE.GRAND, true, false, false, false, false, false, false, true, false, 3L, 1L, player,
//                        System.currentTimeMillis());
//      gameRepository.save(g);
//    });
  }
}
