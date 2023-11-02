package dambi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class JsonZuhaitzaSortu {
    public static void main(String[] args) throws FileNotFoundException {
        
        JsonObject model = Json.createObjectBuilder()
            .add("izena", "Lazkao")
            .add("abizena", "Txiki")
            .add("okupazioa", "Bertsolaria")
            .add("bizilekua", "Abaltzisketa")
            .build();
        
        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream("jsonfiles/data/Irteera.json"))) {
            jsonWriter.writeObject(model);
        }
    }
}
