package ServiciosRed.AnalizadorWebAvanzado;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class AnalizadorWeb {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        URL url = null;

        // 1. Solicitar URL válida
        while (true) {
            System.out.print("Introduce una URL: ");
            String entrada = sc.nextLine();
            try {
                url = new URL(entrada);
                break;
            } catch (MalformedURLException e) {
                System.out.println(" URL no válida. Intenta de nuevo.\n");
            }
        }

        // 2. Mostrar información básica
        System.out.println("\n=== Información de la URL ===");
        System.out.println("Protocolo: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Puerto: " + url.getPort());
        System.out.println("Ruta: " + url.getPath());
        System.out.println("Archivo: " + url.getFile());
        System.out.println("Consulta: " + url.getQuery());

        // 3. Establecer conexión
        try {
            URLConnection conexion = url.openConnection();

            // Configuración de la conexión
            conexion.setConnectTimeout(5000); // 5 segundos
            conexion.setReadTimeout(5000);
            conexion.setRequestProperty("User-Agent", "AnalizadorWeb/1.0");

            // 4. Obtener información del servidor
            System.out.println("\n=== Información del servidor ===");
            System.out.println("Tipo de contenido: " + conexion.getContentType());
            System.out.println("Longitud del contenido: " + conexion.getContentLength());

            // 5. Leer las primeras 10 líneas
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conexion.getInputStream()));
                 BufferedWriter bw = new BufferedWriter(new FileWriter("resultado.html"))) {

                System.out.println("\n=== Primeras 10 líneas del contenido ===");
                String linea;
                int contador = 0;

                while ((linea = br.readLine()) != null && contador < 10) {
                    contador++;
                    System.out.println("Línea " + contador + ": " + linea);
                    bw.write(linea + "\n");
                }

                System.out.println("\n Contenido guardado en 'resultado.html'");
            }

        } catch (IOException e) {
            System.out.println(" Error al conectar o leer la URL: " + e.getMessage());
        }
    }
}

