package dambi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainMenua {

    public static String fitxategia = "mendiencsva\\Mendiak.csv";
    public static BufferedReader input = null;

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        int aukera = 0;

        do {

            System.out.println();
            System.out.println("ONGI ETORRI MENDIEN PROGRAMARA");
            System.out.println("==================================");
            System.out.println();
            System.out.println("MENDIEN MENUA =>");
            System.out.println("---------------------------");
            System.out.println("1. Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2. Mendirik altuena bistaratu");
            System.out.println("3. Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4. ...");
            System.out.println("5. Irten");
            System.out.println("---------------------------");
            System.out.print("Zein nahi duzu exekutata? ");
            aukera = in.nextInt();

            switch (aukera) {
                case 1:
                    mendienZerrenda();
                    break;

                case 2:
                    mendiAltuena();
                    break;

                case 3:
                    esportatu();
                    break;

                case 5:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik!");
                    break;

                default:
                    System.out.println("Aukera okerra, saiatu berriz mesedez");
                    break;
            }
        } while (aukera != 5);

        in.next();
    }

    public static void mendienZerrenda() throws IOException {

        System.out.println();
        System.out.println("Mendien Taula =>");
        System.out.println();

        input = new BufferedReader(new FileReader(fitxategia));
        String abc;

        try {

            while ((abc = input.readLine()) != null) {
                String[] strArr = abc.split(";");

                for (String datua : strArr)
                    System.out.printf("%15s", datua + " | ");
                System.out.println();

            }

            System.out.println();

        } finally {

            if (input != null) {
                input.close();
            }
        }
    }

    public static void mendiAltuena() throws IOException {

        input = new BufferedReader(new FileReader(fitxategia));
        String abc;

        int mendiAltuena = 0;
        String mendia = "";

        while ((abc = input.readLine()) != null) {
            String[] strArr = abc.split(";");

            try {
                if (Integer.parseInt(strArr[1]) > mendiAltuena) {
                    mendiAltuena = Integer.parseInt(strArr[1]);
                    mendia = strArr[0];
                }

            } catch (Exception ex) {
                continue;
            }
        }

        System.out.println();
        System.out.println("MENDIRIK ALTUENA =>");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Mendirik altuena " + mendia + " da, eta " + mendiAltuena + " metro ditu");
        System.out.println();
    }

    public static void esportatu() throws IOException {

        BufferedReader input = null;
        PrintWriter gipuzkoa = null;
        PrintWriter araba = null;
        PrintWriter bizkaia = null;
        PrintWriter naparroa = null;

        try {
            input = new BufferedReader(new FileReader(fitxategia));
            gipuzkoa = new PrintWriter(new FileWriter("Gipuzkoa.csv"));
            araba = new PrintWriter(new FileWriter("Araba.csv"));
            bizkaia = new PrintWriter(new FileWriter("Bizkaia.csv"));
            naparroa = new PrintWriter(new FileWriter("Nafarroa.csv"));

            String abc;

            while ((abc = input.readLine()) != null) {
                String[] eremuak = abc.split(";");

                switch (eremuak[2]) {
                    case "Gipuzkoa":
                        gipuzkoa.println(abc);
                        break;

                    case "Araba":
                        araba.println(abc);
                        break;

                    case "Bizkaia":
                        bizkaia.println(abc);
                        break;

                    case "Nafarroa":
                        naparroa.println(abc);
                        break;

                    default:
                        break;
                }
            }
            
        } catch (FileNotFoundException e) {

            System.out.println("Fitxategia ezin izan da aurkitu, saiatu berriro mesedez");

        } finally {

            if (input != null) {
                input.close();
            }
            if (gipuzkoa != null) {
                gipuzkoa.close();
            }
            if (araba != null) {
                araba.close();
            }
            if (bizkaia != null) {
                bizkaia.close();
            }
            if (naparroa != null) {
                naparroa.close();
            }
        }

    }

}
