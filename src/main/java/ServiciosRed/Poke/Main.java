package ServiciosRed.Poke;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    // Herramientas estáticas para usar en todo el main
    static ClienteHttp http = new ClienteHttp();
    static Gson gson = new Gson();
    static Gson gsonBonito = new GsonBuilder().setPrettyPrinting().create();

    // Variable para guardar el Pokemon que hemos buscado
    static Pokemon pokemonActual = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("\n--- EXAMEN POKEMON (MODO GSON) ---");
            System.out.println("1. API: Buscar Pokemon (Nombre o ID)");
            System.out.println("2. API: Listar los primeros 10 Pokemon");
            System.out.println("3. FICHERO: Guardar JSON del Pokemon actual");
            System.out.println("4. FICHERO: Descargar imagen del Pokemon");
            System.out.println("5. FTP: Subir el JSON guardado");
            System.out.println("0. Salir");
            System.out.print("Elige: ");

            op = sc.nextInt(); sc.nextLine(); // Limpiar buffer

            switch (op) {
                case 1:
                    System.out.print("Introduce nombre (ej: pikachu) o ID: ");
                    String busqueda = sc.nextLine().toLowerCase();
                    String url = "https://pokeapi.co/api/v2/pokemon/" + busqueda;

                    String json = http.getJson(url);

                    if (json != null) {
                        // ¡AQUI OCURRE LA MAGIA! De String -> Objeto Pokemon
                        pokemonActual = gson.fromJson(json, Pokemon.class);
                        System.out.println("¡Encontrado!");
                        System.out.println(pokemonActual); // Usa el toString()
                    } else {
                        System.out.println("Pokemon no encontrado.");
                    }
                    break;

                case 2:
                    // Pedimos una lista (limit=10)
                    String urlLista = "https://pokeapi.co/api/v2/pokemon?limit=10";
                    String jsonLista = http.getJson(urlLista);

                    if (jsonLista != null) {
                        // Usamos la clase "ListaPokemon" para parsear
                        ListaPokemon lista = gson.fromJson(jsonLista, ListaPokemon.class);
                        System.out.println("--- Top 10 Pokemon ---");
                        for (ListaPokemon.PokemonSimple p : lista.getResults()) {
                            System.out.println("- " + p.name);
                        }
                    }
                    break;

                case 3:
                    if (pokemonActual != null) {
                        String nombreArchivo = "pokemon_" + pokemonActual.getName() + ".json";
                        try (FileWriter fw = new FileWriter(nombreArchivo)) {
                            // Guardamos el objeto Java en el archivo, formato bonito
                            gsonBonito.toJson(pokemonActual, fw);
                            System.out.println("Guardado en disco: " + nombreArchivo);
                        } catch (Exception e) {
                            System.out.println("Error al guardar fichero.");
                        }
                    } else {
                        System.out.println("Primero busca un pokemon (Opción 1)");
                    }
                    break;

                case 4:
                    if (pokemonActual != null && pokemonActual.getImagenUrl() != null) {
                        try (InputStream in = new URL(pokemonActual.getImagenUrl()).openStream()) {
                            String nombreImagen = pokemonActual.getName() + ".png";
                            Files.copy(in, Paths.get(nombreImagen));
                            System.out.println("Imagen descargada: " + nombreImagen);
                        } catch (Exception e) {
                            System.out.println("Error al descargar imagen (quizás ya existe).");
                        }
                    } else {
                        System.out.println("No hay pokemon seleccionado o no tiene imagen.");
                    }
                    break;

                case 5:
                    if (pokemonActual != null) {
                        String nombreLocal = "pokemon_" + pokemonActual.getName() + ".json";
                        // Lo subimos al FTP con el mismo nombre
                        ServicioFTP.subirArchivo(nombreLocal, nombreLocal);
                    } else {
                        System.out.println("Primero guarda el JSON (Opción 3).");
                    }
                    break;
            }

        } while (op != 0);
    }
}
