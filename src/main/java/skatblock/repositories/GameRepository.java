package skatblock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import skatblock.entitites.Game;

import java.util.Collection;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {

  Optional<Game> findById(Long id);

  Collection<Game> findByPlayerName(String name);
}
