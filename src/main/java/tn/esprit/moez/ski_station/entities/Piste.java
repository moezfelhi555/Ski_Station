package tn.esprit.moez.ski_station.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Piste implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable= false, updatable= false)
    private Long numPiste;
    private String nomPiste;
    private int longueur;
    private int pente;
    @Enumerated()
    @Column(name = "Couleur", nullable = false)
    private Couleur couleur;


}
