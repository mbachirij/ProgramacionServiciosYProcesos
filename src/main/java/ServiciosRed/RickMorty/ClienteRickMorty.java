package ServiciosRed.RickMorty;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteRickMorty {

    private HttpClient cliente;

    public ClienteRickMorty() {
        cliente = HttpClient.newHttpClient();
    }

    // Devuelve el JSON de un personaje por su id

    public String obtenerPersonajePorId(int id) {
        String url = "https://rickandmortyapi.com/api/character/" + id;

        try {
            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> respuesta =
                    cliente.send(peticion, HttpResponse.BodyHandlers.ofString());

            return respuesta.body();

        } catch (Exception e) {
            System.out.println("Error al conectar con la API");
            return null;
        }
    }

    // Devuelve el JSON de la búsqueda por nombre
    public String buscarPersonajePorNombre(String nombre) {
        String url = "https://rickandmortyapi.com/api/character/?name=" + nombre;

        try {
            HttpRequest peticion = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> respuesta =
                    cliente.send(peticion, HttpResponse.BodyHandlers.ofString());

            return respuesta.body();

        } catch (Exception e) {
            System.out.println("Error al buscar personaje");
            return null;
        }
    }
}

