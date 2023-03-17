package tn.esprit.moez.ski_station.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.moez.ski_station.entities.Skieur;
import tn.esprit.moez.ski_station.repositories.SkieurRepository;


import java.util.List;

@Service
public class SkieurServiceImpl implements SkieurService {
    @Autowired
    private SkieurRepository skieurRepository;

    @Override
    public List<Skieur> findAll() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur save(Skieur skieur) {
        skieurRepository.save(skieur);
        return skieur;
    }

    @Override
    public Skieur findById(Long numSkieur) {
        if(skieurRepository.findById(numSkieur).isPresent()) {
            return skieurRepository.findById(numSkieur).get();
        }
        return null;
    }

    @Override
    public void delete(Long numSkieur) {
        Skieur skieur = findById(numSkieur);
        skieurRepository.delete(skieur);
    }
}
