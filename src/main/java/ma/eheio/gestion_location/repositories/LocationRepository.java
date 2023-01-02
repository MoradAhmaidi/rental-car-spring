package ma.eheio.gestion_location.repositories;

import ma.eheio.gestion_location.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {
}
