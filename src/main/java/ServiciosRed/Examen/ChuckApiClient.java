package ServiciosRed.Examen;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

// Se permite usar Gson o procesamiento manual
// (importar si es necesario)

public class ChuckApiClient {

    private static final String BASE_URL = "https://api.chucknorris.io/jokes/";

    private final HttpClient client = HttpClient.newHttpClient();

    private String ultimoJson;
    private String ultimaCategoria;

    public void listarCategorias() {
        ArrayList<String> categorias = new ArrayList<>();
        try {
            // TODO:
            // 1. Realizar petición GET a /categories
            String url = BASE_URL + "categories";
            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> respuesta = client.send(peticion, HttpResponse.BodyHandlers.ofString());
            // 2. Procesar el JSON recibido
            // 3. Mostrar todas las categorías por pantalla


        } catch (Exception e) {
            System.out.println("Error al listar Categorías");

        }
    }

    public void obtenerChisteAleatorio() {

        try {
            // TODO:
            // 1. Petición GET a /random
            String url = BASE_URL + "random";
            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> respuesta = client.send(peticion, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

            // 2. Guardar el JSON recibido en ultimoJson
            // 3. Extraer y guardar la categoría (si existe)
            // 4. Mostrar la información del chiste
        } catch (Exception e) {
            System.out.println("Error al obtener un chiste aleatorio");
        }
    }

    public void obtenerChistePorCategoria(String categoria) {
        HttpClient client = HttpClient.newHttpClient();
        try {
            // TODO:
            // 1. Petición GET a /random?category=...
            String url = BASE_URL + "random?category=" + categoria;
            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> respuesta = client.send(peticion, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

            // 2. Guardar el JSON recibido en ultimoJson

            // 3. Guardar la categoría
            // 4. Mostrar la información del chiste
        } catch (Exception e) {
            System.out.println("Error "+ e.getMessage());
        }
    }

    public String getUltimoJson() {
        // TODO: devolver el último JSON obtenido
        return null;
    }

    public String getUltimaCategoria() {
        // TODO: devolver la categoría del último chiste

        return null;
    }
}
