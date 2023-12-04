package dambi.accessingrelationaldata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/hasi")
public class ZerbitzuController {

    @Autowired
    private ZerbitzuaRepository zerbitzuRepository;

    @PostMapping(path = "/zerbitzuaGehitu")
    public @ResponseBody String zerbitzuaGehitu(@RequestParam String zerbitzuIzena, @RequestParam String deskribapena) {

        Zerbitzua zerbitzua = new Zerbitzua();
        zerbitzua.setZerbitzuIzena(zerbitzuIzena);
        zerbitzua.setDeskribapena(deskribapena);
        zerbitzuRepository.save(zerbitzua);
        return "Zerbitzua gorde egin da";
    }
    
    @GetMapping(path = "/zerbitzuakLortu")
    public @ResponseBody Iterable<Zerbitzua> zerbitzuakLortu() {
        return zerbitzuRepository.findAll();
    }
}
