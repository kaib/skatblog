package skatblock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    @Bean
    CommandLineRunner init(GameRepository gameRepository,
                           PlayerRepository playerRepository) {
        return (evt) -> Arrays.asList(
                "kai,arne,chrissi,borsti".split(","))
                .forEach(
                        a -> {
                            Player player = playerRepository.save(new Player(a));
                            Game g = new Game(System.currentTimeMillis(), GAME_TYPE.GRAND, true, 0L, 0L, 0L, 0L, 0L, 0L, true, false, 3L, 1L, player, System.currentTimeMillis());
                            gameRepository.save(g);
                        });
    }
}
