package tn.esprit.moez.ski_station.services;



import tn.esprit.moez.ski_station.entities.Abonnement;

import java.util.List;

public interface AbonnementService {
    public List<Abonnement> findAll();

    public Abonnement save(Abonnement abonnement);

    public Abonnement findById(Long numAbon);

    public void delete(Long numAbon);
}
