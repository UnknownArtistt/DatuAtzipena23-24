package dambi;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType (propOrder = {"izena", "kokapena", "probintzia", "altuera"})
@XmlRootElement (name = "Mendia")
public class Mendia {

    private String izena;
    private String kokapena;
    private String probintzia;
    private int altuera;

    public Mendia() {

    }

    public Mendia(String izena, String kokapena, String probintzia, int altuera) {
        this.izena = izena;
        this.kokapena = kokapena;
        this.probintzia = probintzia;
        this.altuera = altuera;
    }
    
    public String getIzena() {
        return izena;
    }

    public String getKokapena() {
        return kokapena;
    }

    public String getProbintzia() {
        return probintzia;
    }

    public int getAltuera() {
        return altuera;
    }

    @XmlElement (name = "Izena")
    public void setIzena(String izena) {

        this.izena = izena;
    }

    @XmlElement (name = "Kokapena")
    public void setKokapena(String kokapena) {

        this.kokapena = kokapena;
    }

    @XmlElement (name = "Probintzia")
    public void setProbintzia(String probintzia) {

        this.probintzia = probintzia;
    }

    @XmlElement (name = "Altuera")
    public void setAltuera(int altuera) {

        this.altuera = altuera;
    }
}
