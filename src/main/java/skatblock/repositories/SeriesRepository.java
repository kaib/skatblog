package skatblock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skatblock.entitites.Series;

import java.util.Optional;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {

  Optional<Series> findById(Long id);
}

