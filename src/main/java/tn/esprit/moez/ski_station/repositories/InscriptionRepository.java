package tn.esprit.moez.ski_station.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.moez.ski_station.entities.Inscription;

@Repository
public interface InscriptionRepository extends CrudRepository<Inscription, Long> {
}
