package tn.esprit.moez.ski_station.services;


import tn.esprit.moez.ski_station.entities.Cours;

import java.util.List;

public interface CoursService {
    public List<Cours> findAll();

    public Cours save(Cours cours);

    public Cours findById(Long numCours);

    public void delete(Long numCours);
}
