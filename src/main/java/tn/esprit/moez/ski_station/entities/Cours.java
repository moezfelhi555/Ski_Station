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
public class Cours implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable= false, updatable= false)
    private Long numCours;
    private int niveau;


    private Float prix;
    private int creneau;
    @Enumerated()
    @Column(name = "TypeCours", nullable = false)
    private TypeCours typecours;
    @Enumerated()
    @Column(name = "Support", nullable = false)
    private Support support;


}
