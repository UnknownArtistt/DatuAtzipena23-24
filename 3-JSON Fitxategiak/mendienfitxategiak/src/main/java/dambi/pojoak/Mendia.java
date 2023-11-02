package dambi.pojoak;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id", "mendia", "altuera", "probintzia"})
@XmlRootElement(name = "Mendia")
public class Mendia {

    private int id;
    private String mendia;
    private int altuera;
    private String probintzia;
    
    public Mendia() {

    }

    public Mendia(int id, String mendia, int altuera, String probintzia) {
        this.id = id;
        this.mendia = mendia;
        this.altuera = altuera;
        this.probintzia = probintzia;
    }

    @XmlAttribute (name = "Id")
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement (name = "Mendia")
    public void setMendia(String mendia) {
        this.mendia = mendia;
    }

    @XmlElement (name = "Altuera")
    public void setAltuera(int altuera) {
        this.altuera = altuera;
    }

    @XmlElement (name = "Probintzia")
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }
  
    public int getId() {
        return id;
    }

    public String getMendia() {
        return mendia;
    }

    public int getAltuera() {
        return altuera;
    }

    public String getProbintzia() {
        return probintzia;
    }
}
