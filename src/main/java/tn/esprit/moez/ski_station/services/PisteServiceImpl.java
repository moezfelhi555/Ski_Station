package tn.esprit.moez.ski_station.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.moez.ski_station.entities.Piste;
import tn.esprit.moez.ski_station.repositories.PisteRepository;


import java.util.List;

@Service
public class PisteServiceImpl implements PisteService{
    @Autowired
    private PisteRepository pisteRepository;

    @Override
    public List<Piste> findAll() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste save(Piste piste) {
        pisteRepository.save(piste);
        return piste;
    }

    @Override
    public Piste findById(Long numPiste) {
        if(pisteRepository.findById(numPiste).isPresent()) {
            return pisteRepository.findById(numPiste).get();
        }
        return null;
    }

    @Override
    public void delete(Long numPiste) {
        Piste piste = findById(numPiste);
        pisteRepository.delete(piste);
    }
}
