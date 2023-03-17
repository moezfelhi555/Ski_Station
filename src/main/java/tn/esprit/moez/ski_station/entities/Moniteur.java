package tn.esprit.moez.ski_station.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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


}
