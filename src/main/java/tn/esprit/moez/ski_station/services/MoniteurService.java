package tn.esprit.moez.ski_station.services;


import tn.esprit.moez.ski_station.entities.Moniteur;

import java.util.List;

public interface MoniteurService {

    public List<Moniteur> findAll();

    public Moniteur save(Moniteur moniteur);

    public Moniteur findById(Long numMoniteur);

    public void delete(Long numMoniteur);
}
