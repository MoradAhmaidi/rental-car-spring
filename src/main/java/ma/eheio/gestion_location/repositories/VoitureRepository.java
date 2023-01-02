package ma.eheio.gestion_location.repositories;

import ma.eheio.gestion_location.models.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture,Integer> {
}
