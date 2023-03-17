package tn.esprit.moez.ski_station.services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.moez.ski_station.entities.Cours;
import tn.esprit.moez.ski_station.repositories.CoursRepository;

import java.util.List;

public class CoursServiceImpl implements CoursService{
    @Autowired
    private CoursRepository coursRepository;

    @Override
    public List<Cours> findAll() {
        return coursRepository.findAll();
    }

    @Override
    public Cours save(Cours cours) {
        coursRepository.save(cours);
        return cours;
    }

    @Override
    public Cours findById(Long numCours) {
        if(coursRepository.findById(numCours).isPresent()) {
            return coursRepository.findById(numCours).get();
        }
        return null;
    }

    @Override
    public void delete(Long numCours) {
        Cours cours = findById(numCours);
        coursRepository.delete(cours);
    }
}
