package ma.eheio.gestion_location.repositories;

import ma.eheio.gestion_location.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Integer> {
}
