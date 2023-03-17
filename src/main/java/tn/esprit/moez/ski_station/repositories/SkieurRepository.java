package tn.esprit.moez.ski_station.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.moez.ski_station.entities.Skieur;

@Repository
public interface SkieurRepository extends JpaRepository<Skieur, Long> {
}
