package ma.eheio.gestion_location.repositories;

import ma.eheio.gestion_location.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
}
