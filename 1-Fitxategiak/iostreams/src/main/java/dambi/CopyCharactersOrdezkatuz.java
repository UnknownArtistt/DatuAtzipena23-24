package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharactersOrdezkatuz {
    public static void main(String[] args) throws IOException {
        
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("iostreams\\xanadu.txt");
            outputStream = new FileWriter("iostreams\\karaktereakOrdezkatu.txt");
            int c;

            while ((c = inputStream.read()) != -1) {
                if (c == 'a') {
                    outputStream.write('o');
                } else {
                    outputStream.write(c);
                }
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
