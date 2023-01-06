package ma.eheio.gestion_location.repositories;

import ma.eheio.gestion_location.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

}
