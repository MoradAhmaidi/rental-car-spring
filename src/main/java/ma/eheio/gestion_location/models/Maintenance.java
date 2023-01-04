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

    @ManyToOne
    @JoinColumn(name = "voiture_id",insertable=false, updatable=false)
    private Voiture voiture;
    private int voiture_id;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id",insertable=false, updatable=false)
    private Fournisseur fournisseur;
    private int fournisseur_id;
}
