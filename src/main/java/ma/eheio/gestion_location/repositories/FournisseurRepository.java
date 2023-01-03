package ma.eheio.gestion_location.repositories;

import ma.eheio.gestion_location.models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {
}
