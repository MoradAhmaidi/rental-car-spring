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
public class Game extends ObjetCommun{

    private int nbrPortes;
    private int nbrPassagers;

    @OneToMany(mappedBy = "game")
    private List<Voiture> voitures;
    @ManyToOne
    @JoinColumn(name = "model_id",referencedColumnName = "id")
    private Model model;

    @ManyToMany(mappedBy = "games")
    private List<Caracteristique> caractestiques;


}
