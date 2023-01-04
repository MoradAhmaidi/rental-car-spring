package ma.eheio.gestion_location.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateDepart;
    private Date dateRetoure;
    private float tarif;
    private boolean loue;

    @ManyToOne
    @JoinColumn(name = "client_id",insertable=false, updatable=false)
    private Client client;
    private int client_id;

    @ManyToOne
    @JoinColumn(name = "voiture_id",insertable=false, updatable=false)
    private Voiture voiture;
    private int voiture_id;

}
