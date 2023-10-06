package dambi;

import java.io.File;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import dambi.Mendia;
import dambi.Mendiak;

public class HiruMendiSortu {
    public static void main(String[] args) {
        
        try {

        Mendia gorla = new Mendia("Gorla", "Bergara Vice City", "Gipuzkoa", 671);
        Mendia goiko = new Mendia("Goiko", "Bergara Vice City", "Gipuzkoa", 210);
        Mendia sanmar = new Mendia("San Martzial", "Bergara Vice City", "Gipuzkoa", 250);
        
        Mendiak mendiak = new Mendiak();
        mendiak.addMendia(gorla);
        mendiak.addMendia(goiko);
        mendiak.addMendia(sanmar);

        JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(mendiak, new File("hiru_mendi.xml"));
        jaxbMarshaller.marshal(mendiak, System.out);

    } catch (JAXBException ex) {
        ex.printStackTrace();
    }

    }
}
