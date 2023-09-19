package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharactersMaiuskulaz {
    
public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("iostreams\\xanadu.txt");
            outputStream = new FileWriter("iostreams\\characterMaiuskulaz.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                char maiuskula = (char)Character.toUpperCase(c);
                outputStream.write(maiuskula);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}