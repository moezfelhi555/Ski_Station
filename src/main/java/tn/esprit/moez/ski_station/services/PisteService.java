package tn.esprit.moez.ski_station.services;


import tn.esprit.moez.ski_station.entities.Piste;

import java.util.List;

public interface PisteService {
    public List<Piste> findAll();

    public Piste save(Piste piste);

    public Piste findById(Long numPiste);

    public void delete(Long numPiste);
}
