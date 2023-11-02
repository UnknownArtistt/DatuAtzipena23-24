package dambi.atzipenekoak;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import dambi.pojoak.Mendiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Xmla {
    
    private String strFileIn;
    private String strFileOut;

    public Xmla() {

    }

    public Xmla(String strFileIn) {
        this.strFileIn = "mendienfitxategia/data/" + strFileIn;
    }

    public Xmla(String strFileIn, String strFileOut) {
        this.strFileIn = "mendienfitxategiak/data/" + strFileIn;
        this.strFileOut = "mendienfitxategiak/data/" + strFileOut;
    }

    public Mendiak irakurri() {

        Mendiak mendiak = new Mendiak();

        try {
            File sarreraFile = new File(strFileIn); // fitxategi berria sortu 
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class); // Mendiak klasea errekonozitu kontextu berrian
            Unmarshaller jUnmarshaller = jaxbContext.createUnmarshaller(); // unmarshal-erra sortu
            mendiak = (Mendiak)jUnmarshaller.unmarshal(sarreraFile); // unmarshal-ak sortu duen objektua Mendiak objektura casteatu

        } catch (Exception z) {
            System.out.println("Errore bat gertatu da=> " + z.getMessage());
        }

        return mendiak;
    }

    public int idatzi(Mendiak mendiak) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            Marshaller jMarshaller = jaxbContext.createMarshaller();
            File fitxBerria = new File(strFileOut);
            OutputStream outpStr = new FileOutputStream(fitxBerria);
            jMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jMarshaller.marshal(mendiak, outpStr);
        } catch (Exception x) {
            System.out.println("Errore bat gertatu da=> " + x.getMessage());
        }
        return mendiak.getMendiak().size();
    }
}
