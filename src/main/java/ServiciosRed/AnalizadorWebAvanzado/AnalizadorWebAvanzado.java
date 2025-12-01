package ServiciosRed.AnalizadorWebAvanzado;

import java.net.URL;
import java.util.Scanner;

public class AnalizadorWebAvanzado {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la URL: ");
        String url = sc.nextLine();
        try {
            if (esURLValida(url)) {

                URL url1 = new URL(url);

                System.out.println("Protocolo: " + url1.getProtocol());
                System.out.println("Host: " + url1.getHost());
                System.out.println("Puerto: " + url1.getPort());
                System.out.println("Ruta: " + url1.getPath());
                System.out.println("Archivo: " + url1.getFile());
                System.out.println("Consulta: " + url1.getQuery());



            } else {
                System.out.println("La URL no es valida, prueba de nuevo");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static boolean esURLValida(String url){

        try {
            new URL(url);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
