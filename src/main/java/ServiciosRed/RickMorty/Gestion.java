package ServiciosRed.RickMorty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Gestion {

    // Guarda el JSON del personaje en un archivo .json
    public static void guardarJsonPersonaje(Personaje p, String json) {

        String nombreArchivo = "character_" + p.getId() + ".json";

        try (FileWriter fw = new FileWriter(nombreArchivo)) {
            fw.write(json);
            System.out.println("JSON guardado en " + nombreArchivo);
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo JSON");
        }
    }

    // Descarga la imagen del personaje y la guarda en la carpeta "imagenes"
    public static void descargarImagen(Personaje p) {

        String carpeta = "imagenes";
        File dir = new File(carpeta);

        if (!dir.exists()) {
            dir.mkdir();
        }

        String nombreImagen = carpeta + "/" +
                p.getNombre().toLowerCase().replace(" ", "_") + ".jpeg";

        try {
            HttpClient cliente = HttpClient.newHttpClient();

            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(p.getUrlImagen()))
                    .GET()
                    .build();

            HttpResponse<InputStream> respuesta =
                    cliente.send(peticion, HttpResponse.BodyHandlers.ofInputStream());

            try (InputStream is = respuesta.body();
                 FileOutputStream fos = new FileOutputStream(nombreImagen)) {

                byte[] buffer = new byte[1024];
                int leidos;

                while ((leidos = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, leidos);
                }
            }

            System.out.println("Imagen guardada en la carpeta 'imagenes'");

        } catch (Exception e) {
            System.out.println("Error al descargar la imagen");
        }
    }
}
