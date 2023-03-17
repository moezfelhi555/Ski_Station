package tn.esprit.moez.ski_station.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.moez.ski_station.entities.Cours;

@Repository
public interface CoursRepository extends JpaRepository<Cours,Long> {
}
