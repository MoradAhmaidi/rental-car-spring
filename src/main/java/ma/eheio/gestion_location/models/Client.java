package ma.eheio.gestion_location.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client extends Personne {

    private String cin;

    @OneToMany(mappedBy = "client")
    private List<Location> locations;
}
