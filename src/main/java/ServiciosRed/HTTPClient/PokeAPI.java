package ServiciosRed.HTTPClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokeAPI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del Pokémon: ");
        String pokemon = sc.nextLine().trim().toLowerCase();

        try {
            String url = "https://pokeapi.co/api/v2/pokemon/" + pokemon;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(url))
                    .header("User-Agent", "Mozilla/5.0")
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

            if (response.statusCode() != 200) {
                System.err.println("Error HTTP: " + response.statusCode());
                return;
            }

            String json = response.body();

            // ---------------------------------------------------
            // 1. GUARDAR EL JSON EN UN FICHERO
            // ---------------------------------------------------

            String ruta = "pokemon_" + pokemon + ".json";
            Files.writeString(Path.of(ruta), json, StandardCharsets.UTF_8);

            System.out.println("\nArchivo guardado correctamente en: " + ruta);

            // ---------------------------------------------------
            // 2. MOSTRAR SOLO DATOS IMPORTANTES
            // ---------------------------------------------------

            String nombre = extraer(json, "\"name\":\"", "\"");
            String id = extraer(json, "\"id\":", ",");
            String height = extraer(json, "\"height\":", ",");
            String weight = extraer(json, "\"weight\":", ",");

            List<String> tipos = new ArrayList<>();
            String[] partes = json.split("\"type\":\\{\"name\":\"");
            for (int i = 1; i < partes.length; i++) {
                tipos.add(partes[i].split("\"")[0]);
            }

            System.out.println("\n=== Información del Pokémon ===");
            System.out.println("Nombre: " + nombre);
            System.out.println("ID: " + id);
            System.out.println("Altura: " + height);
            System.out.println("Peso: " + weight);
            System.out.println("Tipos: " + String.join(", ", tipos));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para extraer valores simples del JSON
    private static String extraer(String json, String inicio, String fin) {
        try {
            int p1 = json.indexOf(inicio) + inicio.length();
            int p2 = json.indexOf(fin, p1);
            return json.substring(p1, p2);
        } catch (Exception e) {
            return "No disponible";
        }
    }
}
