package dambi.lehenrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LehenrestapiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LehenrestapiaApplication.class, args);
	}


	@GetMapping("/")
	public String home() {
		return "Gure lehen rest apia martxan dago.";
	}

	@GetMapping("/kaixo")
	public String hello(@RequestParam(value = "izena", defaultValue = "mundua") String izena) {
		return String.format("Kaixo %s!", izena);
	}

	@GetMapping("/zenbatu")
    public String zenbatu(@RequestParam(value = "norarte", defaultValue = "5") String norarte) {
            
        String strEmaitza = "";
        for (int i = 1; i <= Integer.parseInt(norarte); i++) {
            strEmaitza += (i + "\n");
        }

        return strEmaitza;
	}

	@GetMapping("/pendejadas")
	public String pendejo() {

		//String pnj = "╭∩╮( ͡⚆ ͜ʖ ͡⚆)╭∩╮ ICER";
		String pnj = "      ▄▌▐▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▌<br>" +
		       "───▄▄██▌█ Cargamento de pollas<br>" +
		       "▄▄▄▌▐██▌█ <br>" +
		       "███████▌█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▌<br>" +
		       "▀(⊙)▀▀▀▀▀▀▀(⊙)(⊙)▀▀▀▀▀▀▀▀▀▀(⊙)(⊙)<br>";
		
		return pnj;

	}
}


