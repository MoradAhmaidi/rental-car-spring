package ma.eheio.gestion_location.repositories;

import ma.eheio.gestion_location.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
