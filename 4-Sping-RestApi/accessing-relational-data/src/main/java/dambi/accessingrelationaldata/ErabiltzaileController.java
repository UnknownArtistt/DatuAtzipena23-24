package dambi.accessingrelationaldata;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/hasi")
public class ErabiltzaileController {

    @Autowired
    private ErabiltzaileRepository erabiltzaileRepository;

    @PostMapping(path = "/gehitu")
    public @ResponseBody String erabiltzaileaGehitu(@RequestParam String izena, @RequestParam String emaila, 
    @RequestParam String telefonoa) {

        Erabiltzailea erabiltzailea = new Erabiltzailea();
        erabiltzailea.setIzena(izena);
        erabiltzailea.setEmaila(emaila);
        erabiltzailea.setTelefonoa(telefonoa);
        erabiltzaileRepository.save(erabiltzailea);
        return "Erabiltzailea gorde egin da";
    }

    @GetMapping(path = "/denak")
    public @ResponseBody Iterable<Erabiltzailea> erabiltzaileakLortu() {
        return erabiltzaileRepository.findAll();
    }

    @PutMapping(value = "/eguneratu/{id}")
    public ResponseEntity erabiltzaileaEguneratu(@RequestBody Erabiltzailea erabiltzailea, 
    @PathVariable int id) {
        try {
            erabiltzailea.setId(id);
            erabiltzaileRepository.save(erabiltzailea);
            
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();

        }
    }

    @DeleteMapping(path = "/ezabatu/{id}")
    public ResponseEntity erabiltzaileaEzabatu(@PathVariable int id) {

        try {
            erabiltzaileRepository.deleteById(id);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errorea erabiltzailea ezabatzen");
            return ResponseEntity.notFound().build();
        }
    }
    
}
