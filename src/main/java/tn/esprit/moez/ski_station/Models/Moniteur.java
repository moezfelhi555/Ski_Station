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
public class Moniteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idMoniteur;
    private Long numMoniteur;
    private String nomM;
    private String prenomM;
    @Temporal (TemporalType.DATE)
    private Date dateRecu;
}
