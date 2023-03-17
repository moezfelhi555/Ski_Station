package tn.esprit.moez.ski_station.entities;
import java.io.Serializable;

import javax.persistence.*;

@Entity
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
    public Piste(){}
    public Piste(Long numPiste, String nomPiste, int longueur, int pente, Couleur couleur){}

    public Long getNumPiste() {
        return numPiste;
    }

    public void setNumPiste(Long numPiste) {
        this.numPiste = numPiste;
    }

    public String getNomPiste() {
        return nomPiste;
    }

    public void setNomPiste(String nomPiste) {
        this.nomPiste = nomPiste;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getPente() {
        return pente;
    }

    public void setPente(int pente) {
        this.pente = pente;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
}
