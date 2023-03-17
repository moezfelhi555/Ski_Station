package tn.esprit.moez.ski_station.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.moez.ski_station.entities.Piste;
import tn.esprit.moez.ski_station.repositories.PisteRepository;
import tn.esprit.moez.ski_station.services.PisteService;

import java.util.List;

@RestController
@RequestMapping("/api/pistes")
public class PisteController {
        @Autowired
        PisteService pisteService;
    @Autowired
    private PisteRepository pisteRepository;



        @GetMapping("/liste")
        public ResponseEntity<List<Piste>> getReclamations(){
            return new ResponseEntity<>(pisteService.findAll(), HttpStatus.OK);
        }

        @PostMapping("/liste")
        public ResponseEntity<Piste> savePiste(@RequestBody Piste piste){
            Piste pisteO =pisteService.save(piste);
            return new ResponseEntity<Piste>(pisteO, HttpStatus.OK);
        }

        @GetMapping("/liste/{numPiste}")
        public ResponseEntity<Piste> getPiste(@PathVariable("numPiste")Long numPiste){
            Piste piste =pisteService.findById(numPiste);
            return new ResponseEntity<Piste>(piste, HttpStatus.OK);
        }

        @DeleteMapping("/liste/{numPiste}")
        public ResponseEntity<String> deletePiste(@PathVariable("numPiste")Long numPiste){
            pisteService.delete(numPiste);
            return new ResponseEntity<String>("Piste is deleted successufully!", HttpStatus.OK);
        }

        @PutMapping("/update/{numPiste}")
        public ResponseEntity<Piste> updatePiste(@PathVariable Long numPiste, @RequestBody Piste piste){
            Piste pisteO = pisteService.findById(numPiste);


            if(pisteO == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            try {
                pisteO.setNomPiste(piste.getNomPiste());
                pisteO.setLongueur(piste.getLongueur());
                pisteO.setPente(piste.getPente());
                pisteO.setCouleur(piste.getCouleur());
                return new ResponseEntity<>(pisteService.save(pisteO), HttpStatus.CREATED);
            }catch(DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
