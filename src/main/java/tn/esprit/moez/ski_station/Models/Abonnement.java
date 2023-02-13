package tn.esprit.moez.ski_station.Models;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Abonnement implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idAbon;
    private Long numAbon;
    @Temporal (TemporalType.DATE)
    private Date dateDebut;
    @Temporal (TemporalType.DATE)
    private Date dateFin;
    private Float prixAbon;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbon;


}
