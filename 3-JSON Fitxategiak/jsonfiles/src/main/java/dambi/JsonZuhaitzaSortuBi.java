package dambi;

import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class JsonZuhaitzaSortuBi {

    /*
     * {"menu": {
     * "id": "file",
     * "value": "File",
     * "popup": {
     * "menuitem": [
     * {"value": "New", "onclick": "CreateNewDoc()"},
     * {"value": "Open", "onclick": "OpenDoc()"},
     * {"value": "Close", "onclick": "CloseDoc()"}
     * ]
     * }
     * }}
     */
    public static void main(String[] args) throws Exception {
        
        JsonObject model = Json.createObjectBuilder()
            .add("menu", Json.createObjectBuilder()
            .add("id", "file")
            .add("value", "File")
            .add("popup", Json.createObjectBuilder()
                .add("menuItem", Json.createArrayBuilder()
                .add(Json.createObjectBuilder()
                    .add("value", "New")
                    .add("onClick", "CreateNewDoc()"))
                .add(Json.createObjectBuilder()
                    .add("value", "Open")
                    .add("onClick", "OpenDoc()"))
                .add(Json.createObjectBuilder()
                    .add("value", "Close")
                    .add("onClick", "CloseDoc()"))
                )
            )
        ) 
        .build();

        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream("jsonfiles/data/Irteera2.json"))) {
            jsonWriter.writeObject(model);
        }

    }
}
