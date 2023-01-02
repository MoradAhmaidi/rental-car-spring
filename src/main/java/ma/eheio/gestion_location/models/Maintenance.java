package ma.eheio.gestion_location.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance extends ObjetCommun {

    private float tarif;
    private String remarque;

    @ManyToOne
    @JoinColumn(name = "voiture_id",referencedColumnName = "id")
    private Voiture voiture;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id",referencedColumnName = "id")
    private Fournisseur fournisseur;
}
