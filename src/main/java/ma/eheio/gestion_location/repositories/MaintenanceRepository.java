package ma.eheio.gestion_location.repositories;

import ma.eheio.gestion_location.models.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Integer> {
}
