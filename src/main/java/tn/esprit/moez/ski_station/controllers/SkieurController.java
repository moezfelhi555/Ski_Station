package tn.esprit.moez.ski_station.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.moez.ski_station.entities.Skieur;
import tn.esprit.moez.ski_station.repositories.SkieurRepository;
import tn.esprit.moez.ski_station.services.SkieurService;


import java.util.List;

@RestController
@RequestMapping("/api/skieurs")
public class SkieurController {

    @Autowired
    SkieurService skieurService;
    @Autowired
    private SkieurRepository skieurRepository;



    @GetMapping("/liste")
    public ResponseEntity<List<Skieur>> getSkieurs(){
        return new ResponseEntity<>(skieurService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/liste")
    public ResponseEntity<Skieur> saveSkieur(@RequestBody Skieur skieur){
        Skieur SkieurO =skieurService.save(skieur);
        return new ResponseEntity<Skieur>(SkieurO, HttpStatus.OK);
    }

    @GetMapping("/liste/{numSkieur}")
    public ResponseEntity<Skieur> getSkieur(@PathVariable("numSkieur")Long numSkieur){
        Skieur skieur =skieurService.findById(numSkieur);
        return new ResponseEntity<Skieur>(skieur, HttpStatus.OK);
    }

    @DeleteMapping("/liste/{numSkieur}")
    public ResponseEntity<String> deleteSkieur(@PathVariable("numSkieur")Long numSkieur){
        skieurService.delete(numSkieur);
        return new ResponseEntity<String>("Skieur is deleted successufully!", HttpStatus.OK);
    }

    @PutMapping("/update/{numSkieur}")
    public ResponseEntity<Skieur> updateSkieur(@PathVariable Long numSkieur, @RequestBody Skieur skieur){
        Skieur SkieurO = skieurService.findById(numSkieur);


        if(SkieurO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            SkieurO.setNomS(skieur.getNomS());
            SkieurO.setPrenomS(skieur.getPrenomS());
            SkieurO.setDateNaissance(skieur.getDateNaissance());
            SkieurO.setVille(skieur.getVille());
            return new ResponseEntity<>(skieurService.save(SkieurO), HttpStatus.CREATED);
        }catch(DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
