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
public class Model extends ObjetCommun {

    private String path;

    @OneToMany(mappedBy = "model")
    private List<Game> games;

    @ManyToOne
    @JoinColumn(name = "marque_id",insertable=false, updatable=false)
    private Marque marque;
    private int marque_id;

    @ManyToOne
    @JoinColumn(name = "categorie_id",insertable=false, updatable=false)
    private Categorie categorie;
    private int categorie_id;


}
