package dambi.atzipenekoak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class Csva {

    // Sarrerako eta irteerako fitxategien parametroak eraiki
    private String strFileIn;
    private String strFileOut;

    // Konstruktore generikoa sortu
    public Csva() {
    }

    // Sarrerako fitxategia duen konstruktorea eraiki
    public Csva(String strFileIn) {
        this.strFileIn = "mendienfitxategiak/data/" + strFileIn;
    }

    // Sarrerako eta irteerako fitxategiak duen konstruktorea eraiki
    public Csva(String strFileIn, String strFileOut) {
        this.strFileIn = "mendienfitxategiak/data/" + strFileIn;
        this.strFileOut = "mendienfitxategiak/data/" + strFileOut;
    }

    /* Funtzio honek Csv fitxategi bat irakurtzen du */
    public Mendiak irakurri() {

        // Mendiak motatako objektua sortu
        Mendiak mendiak = new Mendiak();
        List<Mendia> mendiakLista = new ArrayList<>(); /*Mendia motako objektua duen lista bat sortu eta ArrayList
                                                       moduan inizializatu */
        BufferedReader inputStream = null; // BufferedReader-a deklaratu
        String line = "";

        try {
            inputStream = new BufferedReader(new FileReader(strFileIn)); /* BufferedReader-a sortu strFileIn-en pasatako
                                                                         path-ean dagoen fitxategia irakurtzeako */
            while ((line = inputStream.readLine()) != null) { // Irakurtzeko ilarak dauden bitartean bloke hau ejekutatu
                String[] mendiBer = inputStream.readLine().split(";"); // Irakurritakoa separatu ; oinarri hartuz
                Mendia mendia = new Mendia(Integer.parseInt(mendiBer[0]), mendiBer[1], Integer.parseInt(mendiBer[2]),
                        mendiBer[3]); // Mendia objektuak sortu irakurritakoarekin
                mendiakLista.add(mendia); // sortutako Mendia-k ArrayList-ara sartu
            }
            mendiak.setMendiak(mendiakLista); // ArrayList-a seteatu Mendiak objektu baten bihurtzeko

        } catch (Exception x) { // eszepzioa
            System.out.println("Errore bat gertatu da=> " + x.getMessage());
        }
        return mendiak; // Mendiak motatako objektu bat bueltatu
    }

    public int idatzi(Mendiak mendiak) {
        int i = 0;
        List<Mendia> mendiakLista = mendiak.getMendiak(); // Lista eskuratu

        try {
            File mendiakFitxategia = new File(strFileOut);
            mendiakFitxategia.createNewFile(); // Csv fitxategi berria sortu

            // FileWriter MendiWriter = new FileWriter(mendiakFitxategia, false);
            BufferedWriter outputStream = new BufferedWriter(new FileWriter(mendiakFitxategia, false));

            /*
             * Listan dauden mendi guztiak fitxategi berrian idatzi (IMPORTANTE bukaeran \n
             * jarri hurrengo mendia hurrengo ilaran idazteko)
             */
            for (i = 0; i <= mendiakLista.size(); i++) {
                outputStream.write(mendiakLista.get(i).getId() + ";" + mendiakLista.get(i).getMendia() + ";"
                        + mendiakLista.get(i).getAltuera() + ";" + mendiakLista.get(i).getProbintzia() + "\n");
            }
            outputStream.close(); // BufferedReader-a itxi

        } catch (Exception z) { // eszepzioa
            System.out.println("Errore bat gertatu da=> " + z.getMessage());
        }
        return i;
    }
}
