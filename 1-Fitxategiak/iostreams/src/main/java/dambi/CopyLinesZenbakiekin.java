package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class CopyLinesZenbakiekin {
    public static void main(String[] args) throws IOException {
        
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        int x = 1;

        try {
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("outputEnumeratuta.txt"));

            String abc;

            while ((abc =inputStream.readLine())!= null) {
                outputStream.println(x + " " + abc);
                x++;
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
