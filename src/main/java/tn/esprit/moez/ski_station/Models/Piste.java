package tn.esprit.moez.ski_station.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPiste; // Clé primaire

    private Long numPiste;

    private String nomPiste;

    @Enumerated(EnumType.STRING)

    private Couleur couleur;

    private Integer longeur;

    private Integer pente;

    public Piste() {
    }

    public Piste(Long numPiste, String nomPiste, Couleur couleur, Integer longeur, Integer pente) {
        this.numPiste = numPiste;
        this.nomPiste = nomPiste;
        this.couleur = couleur;
        this.longeur = longeur;
        this.pente = pente;
    }
    @ManyToMany(mappedBy="Piste" ,cascade = CascadeType.ALL)
    private Set<Skieur> skieur;
}
