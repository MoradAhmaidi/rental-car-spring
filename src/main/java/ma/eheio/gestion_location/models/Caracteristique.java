package ma.eheio.gestion_location.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Caracteristique extends ObjetCommun{

    @ManyToMany
    @JoinTable(
            name = "OptionsGame",
            joinColumns = @JoinColumn(name = "option_Id"),
            inverseJoinColumns = @JoinColumn(name = "game_Id")
    )
    private List<Game> games;
}
