package dambi;

import java.io.File;

import dambi.Mendia;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

    public class MendiBatSortu {
        public static void main(String[] args) throws JAXBException {

            // setterrekin sortu Mendia objektua
            Mendia aizkorri = new Mendia();
            aizkorri.setIzena("Aizkorri");
            aizkorri.setKokapena("Urbia");
            aizkorri.setProbintzia("Gipuzkoa");
            aizkorri.setAltuera(1551);
            
            // konstruktorea erabiliz
            // Mendia aizkorri = new Mendia("Aizkorri", "Urbia", "Gipuzkoa", 1551);

            JAXBContext jaxbContext = JAXBContext.newInstance(Mendia.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(aizkorri, new File("mendibat.xml"));
            jaxbMarshaller.marshal(aizkorri, System.out );
        }
    }

    
    

