package ServiciosRed.Examen;

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

            if (fichero.toFile().exists()) {
                // Leer fichero y convertirlo en array JSON

            }

        }
    }
}
