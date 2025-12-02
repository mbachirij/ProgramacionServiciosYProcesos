package ServiciosRed.HTTPClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PokeAPI {
    public static void main(String[] args) {

        // Crear un objeto Scanner para leer datos desde la consola
        Scanner sc = new Scanner(System.in);

        // 1. Solicitar un Pokémon por consola
        System.out.print("Introduce el nombre de un Pokémon: ");
        String pokemon = sc.nextLine().toLowerCase(); // Convertir el nombre a minúsculas para evitar errores

        // 2. Construir la URL para hacer la solicitud a la API
        String url = "https://pokeapi.co/api/v2/pokemon/" + pokemon;

        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Crear la solicitud HTTP GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET() // Método GET
                .header("Accept", "application/json") // Especificar que esperamos una respuesta JSON
                .build();

        try {
            // 3. Enviar la solicitud y recibir la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Verificar si la respuesta fue exitosa (código de estado 200)
            if (response.statusCode() == 200) {
                String json = response.body(); // Obtener el cuerpo de la respuesta en formato JSON

                // 5. Extraer y mostrar los datos relevantes
                String nombre = extractJsonValue(json, "\"name\":");
                String id = extractJsonValue(json, "\"id\":");
                String altura = extractJsonValue(json, "\"height\":");
                String peso = extractJsonValue(json, "\"weight\":");
                String tipos = extractJsonTypes(json);

                // Mostrar la información del Pokémon
                System.out.println("=== Información del Pokémon ===");
                System.out.println("Nombre: " + nombre);
                System.out.println("ID: " + id);
                System.out.println("Altura: " + altura);
                System.out.println("Peso: " + peso);
                System.out.println("Tipos: " + tipos);
            } else {
                // Si la respuesta no es 200, mostrar un mensaje de error
                System.out.println("Error: No se pudo obtener la información del Pokémon. Código de respuesta: " + response.statusCode());
            }

        } catch (Exception e) {
            // Manejo de excepciones
            System.out.println("Ocurrió un error al realizar la solicitud: " + e.getMessage());
        } finally {
            // Cerrar el Scanner para evitar fugas de recursos
            sc.close();
        }
    }

    // Método para extraer el valor de un campo específico del JSON
    private static String extractJsonValue(String json, String key) {
        int startIndex = json.indexOf(key) + key.length() + 2; // El +2 es para saltar las comillas
        int endIndex = json.indexOf(",", startIndex);
        if (endIndex == -1) { // En caso de que sea el último valor
            endIndex = json.indexOf("}", startIndex);
        }
        return json.substring(startIndex, endIndex).replace("\"", ""); // Eliminar las comillas alrededor del valor
    }

    // Método para extraer los tipos del Pokémon del JSON
    private static String extractJsonTypes(String json) {
        int startIndex = json.indexOf("\"types\":") + "\"types\":".length();
        int endIndex = json.indexOf("]", startIndex);
        String typesJson = json.substring(startIndex, endIndex).trim();

        StringBuilder types = new StringBuilder();
        int typeStart = typesJson.indexOf("\"type\":") + "\"type\":".length();
        while (typeStart != -1) {
            int typeEnd = typesJson.indexOf("}", typeStart);
            String type = typesJson.substring(typeStart + 7, typeEnd - 1); // Obtener el tipo sin las comillas
            if (types.length() > 0) {
                types.append(", ");
            }
            types.append(type);
            typeStart = typesJson.indexOf("\"type\":", typeEnd);
        }
        return types.toString();
    }
}
