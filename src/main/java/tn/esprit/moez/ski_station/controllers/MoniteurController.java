package tn.esprit.moez.ski_station.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.esprit.moez.ski_station.entities.Moniteur;
import tn.esprit.moez.ski_station.repositories.MoniteurRepository;
import tn.esprit.moez.ski_station.services.MoniteurService;


@RestController
@RequestMapping("/api/moniteurs")

public class MoniteurController {
    @Autowired
    MoniteurService moniteurService;
    @Autowired
    private MoniteurRepository moniteurRepository;



    @GetMapping("/liste")
    public ResponseEntity<List<Moniteur>> getMoniteurs(){
        return new ResponseEntity<>(moniteurService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/liste")
    public ResponseEntity<Moniteur> saveMoniteur(@RequestBody Moniteur moniteur){
        Moniteur moniteurO =moniteurService.save(moniteur);
        return new ResponseEntity<Moniteur>(moniteurO, HttpStatus.OK);
    }

    @GetMapping("/liste/{numMoniteur}")
    public ResponseEntity<Moniteur> getMoniteur(@PathVariable("numMoniteur")Long numMoniteur){
        Moniteur moniteur =moniteurService.findById(numMoniteur);
        return new ResponseEntity<Moniteur>(moniteur, HttpStatus.OK);
    }

    @DeleteMapping("/liste/{numMoniteur}")
    public ResponseEntity<String> deleteMoniteur(@PathVariable("numMoniteur")Long numMoniteur){
        moniteurService.delete(numMoniteur);
        return new ResponseEntity<String>("Moniteur is deleted successufully!", HttpStatus.OK);
    }

    @PutMapping("/update/{numMoniteur}")
    public ResponseEntity<Moniteur> updateMoniteur(@PathVariable Long numMoniteur, @RequestBody Moniteur moniteur){
        Moniteur moniteurO = moniteurService.findById(numMoniteur);


        if(moniteurO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            moniteurO.setNomM(moniteur.getNomM());
            moniteurO.setPrenomM(moniteur.getPrenomM());
            moniteurO.setDateRecru(moniteur.getDateRecru());
            moniteurO.setCours(moniteur.getCours());
            return new ResponseEntity<>(moniteurService.save(moniteurO), HttpStatus.CREATED);
        }catch(DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }












}
