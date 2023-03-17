package tn.esprit.moez.ski_station.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Inscription implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable= false, updatable= false)
    private Long numInscription;
    private int numSemaine;
    public Inscription(){}
    public Inscription(Long numInscription, int numSemaine){}
    public Long getNumInscription() {
        return numInscription;
    }

    public void setNumInscription(Long numInscription) {
        this.numInscription = numInscription;
    }

    public int getNumSemaine() {
        return numSemaine;
    }

    public void setNumSemaine(int numSemaine) {
        this.numSemaine = numSemaine;
    }
}
