package ma.eheio.gestion_location.repositories;

import ma.eheio.gestion_location.models.Caractestique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaractestiqueRepository extends JpaRepository<Caractestique,Integer> {
}
