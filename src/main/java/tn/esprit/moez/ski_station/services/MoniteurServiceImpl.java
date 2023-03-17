package tn.esprit.moez.ski_station.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.moez.ski_station.entities.Moniteur;
import tn.esprit.moez.ski_station.repositories.MoniteurRepository;

@Service
public class  MoniteurServiceImpl implements MoniteurService {
    @Autowired
    private MoniteurRepository moniteurRepository;

    @Override
    public List<Moniteur> findAll() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur save(Moniteur moniteur) {
        moniteurRepository.save(moniteur);
        return moniteur;
    }

    @Override
    public Moniteur findById(Long numMoniteur) {
        if(moniteurRepository.findById(numMoniteur).isPresent()) {
            return moniteurRepository.findById(numMoniteur).get();
        }
        return null;
    }

    @Override
    public void delete(Long numMoniteur) {
        Moniteur moniteur = findById(numMoniteur);
        moniteurRepository.delete(moniteur);
    }
}