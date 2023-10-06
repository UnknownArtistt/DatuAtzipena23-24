package dambi;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import dambi.Mendia;
import dambi.Mendiak;

public class Unmarshal {
    public static void main(String[] args) {
        
        try {

            File file = new File("hiru_mendi.xml"); // fitxategia lortu
            JAXBContext jaxbcontext = JAXBContext.newInstance(Mendiak.class); // Mendiak klasea zehaztu
            Unmarshaller jaxbUnmarshaller = jaxbcontext.createUnmarshaller(); // unmarshaller-a sortu
            Mendiak mendiak = (Mendiak)jaxbUnmarshaller.unmarshal(file); // objektua lortu unmarshal bidez

            for (int i = 0; i < mendiak.getMendiak().size(); i++) { // mendiak lista navegatu
                Mendia mendia = mendiak.getMendiak().get(i); // mendiak lortu
                int oinak = (int)(mendia.getAltuera() * 3.28); // altuera oinetara pasatu
                mendia.setAltuera(oinak); // altuera seteatu
            }

            // xml fitxategi berria sortu aldaketekin
            Marshaller jaxbMarshaller = jaxbcontext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(mendiak, new File("mendiak_oinetan.xml"));
            jaxbMarshaller.marshal(mendiak, System.out);

            // Gipuzkoako mendien lista bat sortu
            Mendiak gipuzkoa = new Mendiak();

            // lista bete, probintzia gipuzkoa bada listan sartzen dugu
            for (int i = 0; i < mendiak.getMendiak().size(); i++) {
                Mendia mendia = mendiak.getMendiak().get(i);
                if (mendia.getProbintzia().equals("Gipuzkoa")) {
                    gipuzkoa.addMendia(mendia);
                }
            }

            // fitxategi berria sortzen dugu gipuzkoako mendientzat
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(mendiak, new File("mendiak_gipuzkoan.xml"));
            jaxbMarshaller.marshal(mendiak, System.out);

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
}
