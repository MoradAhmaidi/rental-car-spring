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
public class Voiture extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String matricule;
    private String nChassis;
    private String carburant;
    private String boiteVitesse;
    private int puissance;
    private String color;
    private String etat;
    private int kilometrage;
    private boolean disponibilite;
    private String path;

    @ManyToOne
    @JoinColumn(name = "game_id",insertable=false, updatable=false)
    private  Game game;
    private int game_id;

    @OneToMany(mappedBy ="voiture")
    private List<Maintenance> maintenances;

    @OneToMany(mappedBy = "voiture")
    private List<Location> location;

}
