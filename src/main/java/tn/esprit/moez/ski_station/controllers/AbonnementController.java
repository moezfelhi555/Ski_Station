package tn.esprit.moez.ski_station.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.moez.ski_station.entities.Abonnement;
import tn.esprit.moez.ski_station.repositories.AbonnementRepository;
import tn.esprit.moez.ski_station.services.AbonnementService;

import java.util.List;

@RestController
@RequestMapping("/api/abonnements")
public class AbonnementController {
    @Autowired
    AbonnementService abonnementService;
    @Autowired
    private AbonnementRepository abonnementRepository;



    @GetMapping("/liste")
    public ResponseEntity<List<Abonnement>> getAbonnements(){
        return new ResponseEntity<>(abonnementService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/liste")
    public ResponseEntity<Abonnement> saveAbonnement(@RequestBody Abonnement abonnement){
        Abonnement abonnementO =abonnementService.save(abonnement);
        return new ResponseEntity<Abonnement>(abonnementO, HttpStatus.OK);
    }

    @GetMapping("/liste/{numAbon}")
    public ResponseEntity<Abonnement> getAbonnement(@PathVariable("numAbon")Long numAbon){
        Abonnement abonnement =abonnementService.findById(numAbon);
        return new ResponseEntity<Abonnement>(abonnement, HttpStatus.OK);
    }

    @DeleteMapping("/liste/{numAbon}")
    public ResponseEntity<String> deleteAbonnement(@PathVariable("numAbon")Long numAbon){
        abonnementService.delete(numAbon);
        return new ResponseEntity<String>("Abonnement is deleted successufully!", HttpStatus.OK);
    }

    @PutMapping("/update/{numAbon}")
    public ResponseEntity<Abonnement> updateAbonnement(@PathVariable Long numAbon, @RequestBody Abonnement abonnement){
        Abonnement abonnementO = abonnementService.findById(numAbon);


        if(abonnementO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            abonnementO.setDateDebut(abonnement.getDateDebut());
            abonnementO.setDateFin(abonnement.getDateFin());
            abonnementO.setPrixAbon(abonnement.getPrixAbon());
            abonnementO.setTypeAbon(abonnement.getTypeAbon());
            return new ResponseEntity<>(abonnementService.save(abonnementO), HttpStatus.CREATED);
        }catch(DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
