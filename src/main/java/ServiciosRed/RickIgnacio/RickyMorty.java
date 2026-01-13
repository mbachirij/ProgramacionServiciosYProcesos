package ServiciosRed.RickIgnacio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

// Ignacio Giumento Castilla
public class RickyMorty
{
    // Clases para guardar los datos con Gson
    static class RespuestaApi
    {
        List<Personaje> results;
    }

    static class Personaje
    {
        int id;
        String name;
        String status;
        String species;
        String gender;
        String image;
        Origin origin;
        Location location;
        List<String> episode;
    }

    static class Origin
    {
        String name;
    }

    static class Location
    {
        String name;
    }

    // Variables que vamos a usar en todo el programa
    private static final HttpClient cliente = HttpClient.newHttpClient();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Personaje personaje = null;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 8)
        {
            // Mostramos el menú
            System.out.println("\nMenú Rick y Morty");
            System.out.println("1. Buscar por ID");
            System.out.println("2. Buscar por Nombre");
            System.out.println("3. Guardar JSON local");
            System.out.println("4. Descargar imagen");
            System.out.println("5. Subir JSON al FTP");
            System.out.println("6. Descargar archivo del FTP");
            System.out.println("7. Listar FTP");
            System.out.println("8. Salir");
            System.out.print("Elige: ");

            try
            {
                String linea = sc.nextLine();
                if (linea.isEmpty()) continue;
                opcion = Integer.parseInt(linea);

                switch (opcion)
                {
                    case 1:
                        System.out.print("ID: ");
                        buscarPorId(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nombre: ");
                        buscarPorNombre(sc.nextLine());
                        break;
                    case 3:
                        if (personaje != null) guardarJson();
                        else System.out.println("Primero busca un personaje.");
                        break;
                    case 4:
                        if (personaje != null) descargarImagen();
                        else System.out.println("Primero busca un personaje.");
                        break;
                    case 5:
                        if (personaje != null)
                        {
                            String fichero = "character_" + personaje.id + ".json";
                            ftp("SUBIR", fichero);
                        }
                        else
                        {
                            System.out.println("No hay personaje cargado.");
                        }
                        break;
                    case 6:
                        System.out.print("Nombre del archivo a bajar: ");
                        ftp("BAJAR", sc.nextLine());
                        break;
                    case 7:
                        ftp("LISTAR", null);
                        break;
                    case 8:
                        System.out.println("Fin del programa.");
                        break;
                }
            }
            catch (Exception e)
            {
                System.out.println("Ha fallado algo: " + e.getMessage());
            }
        }
    }

    private static void buscarPorId(String id) throws Exception
    {
        // Montamos la URL con el ID que nos han dado
        String url = "https://rickandmortyapi.com/api/character/" + id;

        // Preparamos la petición
        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Enviamos la petición y esperamos la respuesta
        HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        // Si la respuesta es 200 la cosa sigue
        if (respuesta.statusCode() == 200)
        {
            // Pasamos el texto JSON a objeto Java
            personaje = gson.fromJson(respuesta.body(), Personaje.class);

            System.out.println("ID: " + personaje.id);
            System.out.println("Nombre: " + personaje.name);
            System.out.println("Estado: " + personaje.status);
            System.out.println("Especie: " + personaje.species);
            System.out.println("Género: " + personaje.gender);
            System.out.println("Origen: " + personaje.origin.name);
            System.out.println("Ubicación: " + personaje.location.name);
            System.out.println("Episodios: " + personaje.episode.size());
            System.out.println("Imagen: " + personaje.image);
        }
        else
        {
            System.out.println("Error al buscar: " + respuesta.statusCode());
        }
    }

    private static void buscarPorNombre(String nombre) throws Exception
    {
        // Escribimos la url con el nombre del personaje
        String nombrePersonaje = URLEncoder.encode(nombre, StandardCharsets.UTF_8);
        String url = "https://rickandmortyapi.com/api/character/?name=" + nombrePersonaje;

        // Preparamos la petición
        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Enviamos la petición
        HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        if (respuesta.statusCode() == 200)
        {
            // Como devuelve una lista, usamos la clase auxiliar RespuestaApi
            RespuestaApi lista = gson.fromJson(respuesta.body(), RespuestaApi.class);

            System.out.println("Resultados:");
            for (Personaje p : lista.results)
            {
                System.out.println("[" + p.id + "] " + p.name + " (" + p.status + ")");
            }
        }
        else
        {
            System.out.println("No se ha encontrado nada.");
        }
    }

    private static void guardarJson() throws Exception
    {
        String nombreFichero = "character_" + personaje.id + ".json";

        // Pasamos el objeto Java a texto JSON
        String json = gson.toJson(personaje);

        // Guardamos el fichero en la carpeta del proyecto
        Files.writeString(Path.of(nombreFichero), json, StandardCharsets.UTF_8);
        System.out.println("Fichero guardado: " + nombreFichero);
    }

    private static void descargarImagen() throws Exception
    {
        // Preparamos el nombre
        String nombreFichero = personaje.name.toLowerCase().replace(" ", "_") + ".jpeg";

        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create(personaje.image))
                .build();

        // Descargamos la imagen
        cliente.send(peticion, HttpResponse.BodyHandlers.ofFile(Path.of(nombreFichero)));
        System.out.println("Imagen descargada: " + nombreFichero);
    }

    private static void ftp(String accion, String fichero)
    {
        FTPClient ftp = new FTPClient();
        try
        {
            // Nos conectamos al servidor FTP
            ftp.connect("localhost", 21);

            // Hacemos login con usuario y contraseña
            if (ftp.login("alumno", "1234"))
            {
                // Entramos en modo pasivo para que no falle
                ftp.enterLocalPassiveMode();
                ftp.setFileType(FTP.BINARY_FILE_TYPE);

                if (accion.equals("SUBIR"))
                {
                    System.out.println("Subiendo " + fichero + "...");
                    // Leemos el fichero
                    FileInputStream fis = new FileInputStream(fichero);
                    // Lo subimos al servidor
                    boolean ok = ftp.storeFile(fichero, fis);
                    fis.close();
                    System.out.println(ok ? "Subido." : "Error al subir.");
                }
                else if (accion.equals("BAJAR"))
                {
                    System.out.println("Bajando " + fichero + "...");
                    // Preparamos el fichero para guardar en nuestro ordenador
                    FileOutputStream fos = new FileOutputStream(fichero);
                    // Nos traemos el fichero del servidor
                    boolean ok = ftp.retrieveFile(fichero, fos);
                    fos.close();
                    System.out.println(ok ? "Bajado." : "Error al bajar.");
                }
                else if (accion.equals("LISTAR"))
                {
                    System.out.println("Archivos en FTP:");
                    // Recorremos la lista de archivos del servidor
                    for (FTPFile f : ftp.listFiles())
                    {
                        System.out.println("- " + f.getName());
                    }
                }

                // Cerramos sesión y desconectamos
                ftp.logout();
                ftp.disconnect();
            }
            else
            {
                System.out.println("Login incorrecto.");
            }
        }
        catch (IOException e)
        {
            System.out.println("Error FTP: " + e.getMessage());
        }
    }
}