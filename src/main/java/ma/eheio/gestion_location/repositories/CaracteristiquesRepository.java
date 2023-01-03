package ma.eheio.gestion_location.repositories;

import ma.eheio.gestion_location.models.Caracteristique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaracteristiquesRepository extends JpaRepository<Caracteristique,Integer> {
}
