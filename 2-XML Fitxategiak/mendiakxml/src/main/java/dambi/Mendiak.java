package dambi;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;
import dambi.Mendia;

@XmlRootElement (name = "Mendiak")
public class Mendiak {
    
    List<Mendia> mendiak;

    // getter, lista bueltatzen dou
    public List<Mendia> getMendiak() {
        return mendiak;
    }

    //setter
    public void setMendiak(List<Mendia> mendiak) {
        this.mendiak = mendiak;
    }

    // Mendi bat mendiak listan gehitzen du funtzio honek
    public void addMendia(Mendia mendia) {

        if (this.mendiak == null) {
            this.mendiak = new ArrayList<Mendia>();
        }

        this.mendiak.add(mendia);
    }
}
