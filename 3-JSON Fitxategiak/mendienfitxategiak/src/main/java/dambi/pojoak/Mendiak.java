package dambi.pojoak;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement (name = "Mendiak")
public class Mendiak {
    
    private List<Mendia> mendiak;

    public List<Mendia> getMendiak() {
        return mendiak;
    }

    public void setMendiak(List<Mendia> mendiak) {
        this.mendiak = mendiak;
    }

    public void addMendia(Mendia mendia) {
        if (this.mendiak == null) {
            this.mendiak = new ArrayList<Mendia>();
        }
        this.mendiak.add(mendia);
    }
}
