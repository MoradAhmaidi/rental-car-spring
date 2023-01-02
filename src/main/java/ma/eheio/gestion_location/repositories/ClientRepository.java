package ma.eheio.gestion_location.repositories;

import ma.eheio.gestion_location.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
