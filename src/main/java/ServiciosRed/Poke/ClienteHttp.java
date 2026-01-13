package ServiciosRed.Poke;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {
    private HttpClient cliente;

    public ClienteHttp() {
        this.cliente = HttpClient.newHttpClient();
    }

    public String getJson(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            return (response.statusCode() == 200) ? response.body() : null;
        } catch (Exception e) {
            System.out.println("Error HTTP: " + e.getMessage());
            return null;
        }
    }
}
