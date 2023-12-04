package dambi.restgreeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    
    private static String template;
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Patxi") String name, 
    @RequestParam(value = "hizk", defaultValue = "Kaixo")String hizk) {

        if (hizk.equals("eus")) {
            template = "Kaixo %s!";
        } else if (hizk.equals("esp")) {
            template = "Hola %s!";
        } else if (hizk.equals("eng")) {
            template = "Hellowww %s!";
        }

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
