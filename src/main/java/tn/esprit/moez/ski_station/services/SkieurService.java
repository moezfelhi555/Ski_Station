package tn.esprit.moez.ski_station.services;


import tn.esprit.moez.ski_station.entities.Skieur;

import java.util.List;

public interface SkieurService {
    public List<Skieur> findAll();

    public Skieur save(Skieur skieur);

    public Skieur findById(Long numSkieur);

    public void delete(Long numSkieur);
}
