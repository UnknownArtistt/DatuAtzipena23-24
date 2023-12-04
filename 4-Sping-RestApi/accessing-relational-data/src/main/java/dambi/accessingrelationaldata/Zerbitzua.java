package dambi.accessingrelationaldata;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Zerbitzua {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String zerbitzuIzena;
    private String deskribapena;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZerbitzuIzena() {
        return zerbitzuIzena;
    }

    public void setZerbitzuIzena(String zerbitzuIzena) {
        this.zerbitzuIzena = zerbitzuIzena;
    }

    public String getDeskribapena() {
        return deskribapena;
    }

    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }

}
