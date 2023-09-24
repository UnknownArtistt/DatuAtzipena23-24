package dambi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainMenua {
    public static void main(String[] args) throws IOException {
        
        Scanner auk = new Scanner(System.in);
        int aukera = 0;

        do {

            // Menu nagusia bistaratu
            System.out.println();
            System.out.println("ONGI ETORRI FILEIO PROGRAMARA =>");
            System.out.println("-----------------------------------------------------------");
            System.out.println("1.- Fitxategi edo direktoria bat existitzen den ikusi");
            System.out.println("2.- Direktorio baten edukia bistaratu");
            System.out.println("3.- Direktorio egitura bat sortu");
            System.out.println("4.- Fitxategi bat sortu");
            System.out.println("5.- Irten");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Aukeratu zein funtzionalitate nahi duzun egin=> ");
            System.out.println("-----------------------------------------------------------");
            System.out.println("");
            // Erabiltzailearen aukera batu
            aukera = auk.nextInt();

            // Switch bat, kasu bakoitzean bere funtzioari deitu
            switch (aukera) {

                case 1:
                    rutaBilatu();
                    break;
                case 2:
                    edukiaBistaratu();
                    break;
                case 3:
                    egituraSortu();
                    break;
                case 4:
                    fitxategiaSortu();
                    break;
                
                default:
                    System.out.println("Aukera okerra. Aukerak 1-etik 5-era enumeratzen dira!.");
                    break;
            }
        } while (aukera != 5);
    }
    
    /* Funtzio honek erabiltzaileari fitxategi edo direktorio baten path absolutua eskatzen dio eta sisteman aurkitzen den 
    konprobatzen du. Koinzidentziarik ez badu topatzen berriz saiatzeko eskatzen dio. */ 
    public static void rutaBilatu() throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Sartu ezazu zure fitxategi edo direktorioaren path absolutua mesedez=> ");
        // Path-a eskatu erabiltzaileari
        String rutaAbs = sc.next();

        // Jasotako path-a sortu
        Path eskatutakoRuta = Paths.get(rutaAbs);

        // Existitzen den konprobatu eta hala bada mezu bat bistaratu
        try {
            Path er = eskatutakoRuta.toRealPath();
            System.out.println("Erraztutako ruta sisteman aurkitzen da");
        // Ez bada existitzen mezu bat bistaratu
        } catch (NoSuchFileException n) {
            System.out.println("Erraztutako ruta ez da sisteman aurkitzen, saiatu berriz mesedez");
            System.out.println("");
        }
    }

    /* Funtzio honek sartutako direktorio baten lehen mailako edukia bistartuko du */
    public static void edukiaBistaratu() throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.println("Sartu ezazu zure direktorioaren path absolutua mesedez=> ");
        // Path-a jaso
        String bilatzekoPath = in.next();

        File dirBerria = new File(bilatzekoPath);

        // Existitzen den eta direktorio bat dela egiaztatu
        if (dirBerria.exists() && dirBerria.isDirectory()) {

            // Fitxategiak enlistatu
            File[] barrukoEdukia = dirBerria.listFiles();

            // Barruan fitxategirik badago
            if (barrukoEdukia != null && barrukoEdukia.length > 0) {

                System.out.println("Karpetaren edukia honako hau da =>");
                System.out.println("---------------------------------------------------------");

                // Barruko fitxategi bakoitza inprimatu
                for (File edukia : barrukoEdukia) {
                    if(edukia.isFile()) {
                        System.out.println("|- " + edukia.getName());
                    } else if(edukia.isDirectory()) {
                        System.out.println("|- " + edukia.getName() + " / ");
                    }
                } 
            // Direktorioa hutsik dagoela bistaratu
            } else {
                System.out.println("Karpeta honek ez du edukirik bistaratzeko");
            } 
        // Direktorioa existitzen ez dela bistaratu
        } else {
            System.out.println("Direktorio hau ez da sisteman aurkitzen");    
        }
    }

    /* Funtzio honek karpeta egitura hau sortu behar du
    /* karpeta_berriak
        ├── animaliak
        │   ├── arrainak
        │   └── ugaztunak
        └── elikagaiak
        ├── barazkiak
        └── esnekiak
    */
    public static void egituraSortu() throws IOException {

        // Karpetak sortuko diren jatorria
        Path pathErlatiboa = Paths.get("fileio/Karpetak");

        // Karpeta bakoitzaren ruta
        Path animaliak = Paths.get(pathErlatiboa + "/animaliak");
        Path elikagaiak = Paths.get(pathErlatiboa + "/elikagaiak");
        Path barazkiak = Paths.get(pathErlatiboa + "/barazkiak");
        Path esnekiak = Paths.get(pathErlatiboa + "/esnekiak");

        Path arrainak = Paths.get(pathErlatiboa + "/animaliak/arrainak");
        Path ugaztunak = Paths.get(pathErlatiboa + "/animaliak/ugaztunak");

        try {
            // Direktorioak sortu path erlatiboan
            Files.createDirectory(pathErlatiboa);
            Files.createDirectory(animaliak);
            Files.createDirectory(elikagaiak);
            Files.createDirectory(barazkiak);
            Files.createDirectory(esnekiak);

            Files.createDirectory(arrainak);
            Files.createDirectory(ugaztunak);

            System.out.println("Karpeta egitura era egokian sortu da");

        // Errorea bistaratu jadanik sortuta daudelako
        } catch (FileAlreadyExistsException f) {
            System.out.println("Direktorioa existitzen da jadanik");
            System.out.println("");
        }
    }

    public static void fitxategiaSortu() throws IOException {

        Scanner ex = new Scanner(System.in);

        // Zer nahi duen deskribatu karpeta egokia topatzeko
        System.out.println("Zer nahi duzu deskribatu eta batu? ");
        String dirEgokia = ex.next();

        // Jatorria jaso
        Path pathErlatiboa = Paths.get("fileio/Karpetak");
        // Azpi karpeta jatorri moduan zehaztuko du bariable honek, hutsik inizializatzen dugu
        Path jatorria = Paths.get("");

        switch(dirEgokia.toLowerCase()) {
            case "arrainak":
                jatorria = Paths.get(pathErlatiboa + "/animaliak/arrainak");
                break;

            case "ugaztunak":
                jatorria = Paths.get(pathErlatiboa + "/animaliak/ugaztunak");
                break;

            case "elikagaiak":
                jatorria = Paths.get(pathErlatiboa +  "/elikagaiak");
                break;

            case "barazkiak":
                jatorria = Paths.get(pathErlatiboa +  "/barazkiak");
                break;

            case "esnekiak":
                jatorria = Paths.get(pathErlatiboa +  "/esnekiak");
                break;

            default:
                System.out.println("Aukeratu hauetako bat mesedez (Arrainak, Ugaztunak, Elikagaiak, Barazkiak, Esnekiak)");
                break;
        }

        // Zer nahi duen deskribatu galdetu, fitxategiaren izena
        System.out.println("Zein nahi duzu deskribatu? ");
        String izena = ex.next();

        // Path-a sortu
        Path fitxBerria = Paths.get(jatorria + "/" + izena + ".txt");

        try {
            Files.createDirectories(fitxBerria.getParent());
            // Fitxategia sortu
            Files.createFile(fitxBerria);
        } catch (IOException z) {
            // Errore bat gertatu dela bistaratu
            System.err.println("Errore bat gertatu da, saiatu berriz mesedez, " + z.getMessage());
            System.out.println("");
        }

        // Deskribapena eskatu
        System.out.println("Idatzi deskribapena mesedez => ");
        String desk = ex.next();

        // Karaktere mota ezarri
        Charset karaktereak = Charset.forName("US-ASCII");

        String ed = desk;

        // Fitxategian idatzi
        try (BufferedWriter idatzi = Files.newBufferedWriter(fitxBerria, karaktereak)) {
            idatzi.write(ed, 0, ed.length());
        } catch (IOException t) {
            System.out.println("Errore bat gertatu da, saiatu berriz mesedez");
        }
    }
}
