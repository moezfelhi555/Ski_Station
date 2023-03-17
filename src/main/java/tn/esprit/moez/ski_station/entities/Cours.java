package tn.esprit.moez.ski_station.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
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
    public Cours(){}
    public Cours(Long numCours, int niveau, TypeCours typecours, Support support, Float prix, int creneau){}

    public Long getNumCours() {
        return numCours;
    }

    public void setNumCours(Long numCours) {
        this.numCours = numCours;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public TypeCours getTypecours() {
        return typecours;
    }

    public void setTypecours(TypeCours typecours) {
        this.typecours = typecours;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public int getCreneau() {
        return creneau;
    }

    public void setCreneau(int creneau) {
        this.creneau = creneau;
    }
}
