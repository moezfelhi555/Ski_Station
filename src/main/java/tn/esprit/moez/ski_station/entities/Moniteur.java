package tn.esprit.moez.ski_station.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Moniteur implements Serializable {
    @Id
    private Long numMoniteur;
    private String nomM ;
    private String prenomM ;
    private Date dateRecru ;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Cours> cours;

    public Long getNumMoniteur() {
        return numMoniteur;
    }

    public void setNumMoniteur(Long numMoniteur) {
        this.numMoniteur = numMoniteur;
    }

    public String getNomM() {
        return nomM;
    }

    public void setNomM(String nomM) {
        this.nomM = nomM;
    }

    public String getPrenomM() {
        return prenomM;
    }

    public void setPrenomM(String prenomM) {
        this.prenomM = prenomM;
    }

    public Date getDateRecru() {
        return dateRecru;
    }

    public void setDateRecru(Date dateRecru) {
        this.dateRecru = dateRecru;
    }

    public Set<Cours> getCours() {
        return cours;
    }

    public void setCours(Set<Cours> cours) {
        this.cours = cours;
    }
}
