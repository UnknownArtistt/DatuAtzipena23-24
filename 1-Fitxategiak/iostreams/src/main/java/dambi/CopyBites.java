package dambi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** Programa honek proiektuaren erroan dagoen Xanadu fitxategia bytez byte irakurtzen du, 
* byte bakoitza outagain.txt fitxategian idatziz.
*/
public class CopyBites {
    public static void main(String[] args) throws IOException {
        
        FileInputStream in = null;
        FileOutputStream out = null;

        try {

            in = new FileInputStream("iostreams\\xanadu.txt");
            out = new FileOutputStream("iostreams\\outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }

            if (out != null) {
                out.close();
            }
        }
    }
}