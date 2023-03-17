package tn.esprit.moez.ski_station.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.moez.ski_station.entities.Cours;
import tn.esprit.moez.ski_station.repositories.CoursRepository;
import tn.esprit.moez.ski_station.services.CoursService;


import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CoursController {

    CoursService coursService;
    @Autowired
    private CoursRepository coursRepository;



    @GetMapping("/liste")
    public ResponseEntity<List<Cours>> getCours(){
        return new ResponseEntity<>(coursService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/liste")
    public ResponseEntity<Cours> saveCours(@RequestBody Cours cours){
        Cours CoursO =coursService.save(cours);
        return new ResponseEntity<Cours>(CoursO, HttpStatus.OK);
    }

    @GetMapping("/liste/{numCours}")
    public ResponseEntity<Cours> getCour(@PathVariable("numCours")Long numCours){
        Cours cours =coursService.findById(numCours);
        return new ResponseEntity<Cours>(cours, HttpStatus.OK);
    }

    @DeleteMapping("/liste/{numCours}")
    public ResponseEntity<String> deleteCours(@PathVariable("numCours")Long numCours){
        coursService.delete(numCours);
        return new ResponseEntity<String>("Cours is deleted successufully!", HttpStatus.OK);
    }

    @PutMapping("/update/{numCours}")
    public ResponseEntity<Cours> updateCours(@PathVariable Long numCours, @RequestBody Cours cours){
        Cours CoursO = coursService.findById(numCours);


        if(CoursO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            CoursO.setNiveau(cours.getNiveau());
            CoursO.setTypecours(cours.getTypecours());
            CoursO.setSupport(cours.getSupport());
            CoursO.setPrix(cours.getPrix());
            CoursO.setCreneau(cours.getCreneau());
            return new ResponseEntity<>(coursService.save(CoursO), HttpStatus.CREATED);
        }catch(DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
