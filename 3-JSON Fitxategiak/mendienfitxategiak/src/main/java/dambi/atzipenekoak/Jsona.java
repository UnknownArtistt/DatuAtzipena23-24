package dambi.atzipenekoak;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class Jsona {

    private String strFileIn;
    private String strFileOut;

    public Jsona() {

    }

    public Jsona(String strFileIn) {
        this.strFileIn = "mendienfitxategiak/data/" + strFileIn;
    }

    public Jsona(String strFileIn, String strFileOut) {
        this.strFileIn = "mendienfitxategiak/data/" + strFileIn;
        this.strFileOut = "mendienfitxategiak/data/" + strFileOut;
    }

    public Mendiak irakurri() {
        Mendiak mendiak = new Mendiak();
        JsonObject jsonMendia = null;
        Mendia mendia = null;

        try {
            JsonReader jReader = Json.createReader(new FileReader(strFileOut));
            JsonStructure jEstruktura = jReader.read();
            JsonArray jsonArray = jEstruktura.asJsonArray();

            /* JsonArray-ak JsonValue bueltatzen du, JsonObject bat behar da getString eta getInt erabiltzeko */
            for (int i = 0; i <= jsonArray.size(); i++) {

                jsonMendia = jsonArray.getJsonObject(i);
                mendia = new Mendia(jsonMendia.getInt("id"), jsonMendia.getString("mendia"), 
                    jsonMendia.getInt("altuera"), jsonMendia.getString("probintzia"));

                mendiak.addMendia(mendia);
            }
        } catch (Exception z) {
            System.out.println("Errore bat gertatu da=> " + z.getMessage());
        }
        return mendiak;
    }

    public int idatzi(Mendiak mendiak) {
        
        int i = 0;
        List<Mendia> mendiakList = mendiak.getMendiak();
        Mendia mendia = null;
        JsonArray mendiakArray = null;
        JsonArrayBuilder builder = Json.createArrayBuilder();

        try {
            for (i = 0; i < mendiakList.size(); i++) {
                mendia = mendiakList.get(i);
                JsonObject model = Json.createObjectBuilder()
                        .add("id", mendia.getId())
                        .add("izena", mendia.getMendia())
                        .add("altuera", mendia.getAltuera())
                        .add("probintzia", mendia.getProbintzia())
                        .build();
                builder.add(model);
            }
            mendiakArray = builder.build();
            JsonWriter writer = Json.createWriter(new FileOutputStream(strFileOut));
            writer.writeArray(mendiakArray);

        } catch (Exception x) {
            System.out.println("Errore bat gertatu da: " + x.getMessage());
        }

        return i;
    }
}
