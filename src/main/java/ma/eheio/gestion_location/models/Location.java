package ma.eheio.gestion_location.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location  extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDepart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
