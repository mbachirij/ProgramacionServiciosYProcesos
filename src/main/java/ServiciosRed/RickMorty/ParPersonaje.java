package ServiciosRed.RickMorty;

public class ParPersonaje {

    // Recibe el JSON y crea un objeto Personaje
    public static Personaje parsearPersonaje(String json) {

        if (json == null) {
            return null;
        }

        try {
            int id = Integer.parseInt(
                    json.split("\"id\":")[1].split(",")[0]
            );

            String nombre = json.split("\"name\":\"")[1].split("\"")[0];
            String estado = json.split("\"status\":\"")[1].split("\"")[0];
            String especie = json.split("\"species\":\"")[1].split("\"")[0];
            String genero = json.split("\"gender\":\"")[1].split("\"")[0];

            // Origen
            String parteOrigen = json.split("\"origin\":\\{")[1];
            String origen = parteOrigen.split("\"name\":\"")[1].split("\"")[0];

            // Ubicación
            String parteUbicacion = json.split("\"location\":\\{")[1];
            String ubicacion = parteUbicacion.split("\"name\":\"")[1].split("\"")[0];

            // URL imagen
            String urlImagen = json.split("\"image\":\"")[1].split("\"")[0];

            // Número de episodios
            String bloqueEpisodios = json.split("\"episode\":\\[")[1].split("]")[0];
            int numEpisodios = bloqueEpisodios.split("http").length - 1;

            return new Personaje(
                    id,
                    nombre,
                    estado,
                    especie,
                    genero,
                    origen,
                    ubicacion,
                    numEpisodios,
                    urlImagen
            );

        } catch (Exception e) {
            System.out.println("Error al parsear el JSON del personaje");
            return null;
        }
    }
}

