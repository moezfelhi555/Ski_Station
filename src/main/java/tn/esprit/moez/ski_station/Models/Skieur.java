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
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSkieur;
    private Long numSkieur;
    private String nomS;
    private String prenomS;
    @Temporal (TemporalType.DATE)
    private Date dateNaissance;
    private String ville;

}
