package ServiciosRed.ClaseURL;

import java.net.URL;

public class EjemploURL1 {
    public static void main(String[] args) {

        try {
            URL url = new URL("http://www.google.com");



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
