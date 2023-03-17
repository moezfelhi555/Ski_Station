package tn.esprit.moez.ski_station.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import tn.esprit.moez.ski_station.entities.Moniteur;

@Repository
public interface MoniteurRepository extends JpaRepository<Moniteur, Long> {
}
