package tn.esprit.moez.ski_station.Models;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Inscription implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscri;
    private Long numInscription;
    private int numSemaine;

    @ManyToOne
     Skieur skieur;

    @ManyToOne
    Cours Cours;

}
