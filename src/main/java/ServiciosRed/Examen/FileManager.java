package ServiciosRed.Examen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Se permite usar Gson o procesamiento manual
// (importar si es necesario)

public class FileManager {

    public void guardarChistePorCategoria(String jsonChiste, String categoria) {

        /*
         * TODO:
         * 1. Si el chiste o la categoría son null, no hacer nada
         * 2. Crear el nombre del fichero:
         *      chuck_jokes_<categoria>.json
         * 3. Si el fichero existe:
         *      - Leer su contenido
         *      - Convertirlo en un array JSON
         *    Si no existe:
         *      - Crear un array JSON vacío
         * 4. Añadir el nuevo chiste al array
         * 5. Guardar el array en el fichero (sin sobrescribir datos previos)
         */
        if(jsonChiste == null || categoria == null){
            return;
        } else {
            Path fichero = Path.of("chuck_jokes_"+categoria+".json");
            JsonArray jsonArray;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            if (fichero.toFile().exists()) {
                // Leer fichero y convertirlo en array JSON
                try {
                    String contenido = Files.readString(fichero);
                    jsonArray = JsonParser.parseString(contenido).getAsJsonArray();
                } catch (IOException e) {
                    jsonArray = new JsonArray();
                }
            } else {
                jsonArray = new JsonArray();
            }

            // Añadir el nuevo chiste al array
            jsonArray.add(JsonParser.parseString(jsonChiste));

            // Guardar el array en el fichero
            try {
                Files.writeString(fichero, gson.toJson(jsonArray));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
