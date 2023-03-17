package tn.esprit.moez.ski_station.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.moez.ski_station.entities.Abonnement;
import tn.esprit.moez.ski_station.repositories.AbonnementRepository;

import java.util.List;

@Service
public class AbonnementServiceImpl implements AbonnementService{
    @Autowired
    private AbonnementRepository abonnementRepository;


    public List<Abonnement> findAll() {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement save(Abonnement abonnement) {
        abonnementRepository.save(abonnement);
        return abonnement;
    }

    @Override
    public Abonnement findById(Long numAbon) {
        if(abonnementRepository.findById(numAbon).isPresent()) {
            return abonnementRepository.findById(numAbon).get();
        }
        return null;
    }


    @Override
    public void delete(Long numAbon) {
        Abonnement abonnement = findById(numAbon);
        abonnementRepository.delete(abonnement);
    }

}
