package ServiciosRed.RickMorty;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ClienteRickMorty api = new ClienteRickMorty();
        Personaje personajeActual = null;
        String jsonActual = null;

        int opcion;

        do {
            System.out.println("\n--- MENÚ RICK & MORTY ---");
            System.out.println("1. Buscar personaje por ID");
            System.out.println("2. Buscar personaje por nombre");
            System.out.println("3. Guardar JSON del personaje");
            System.out.println("4. Descargar imagen del personaje");
            System.out.println("5. Subir archivo JSON al FTP");
            System.out.println("6. Descargar archivo del FTP");
            System.out.println("7. Listar archivos del FTP");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Introduce ID del personaje: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    jsonActual = api.obtenerPersonajePorId(id);
                    personajeActual = ParPersonaje.parsearPersonaje(jsonActual);

                    if (personajeActual != null) {
                        personajeActual.mostrar();
                    }
                    break;

                case 2:
                    System.out.print("Introduce nombre del personaje: ");
                    String nombre = sc.nextLine();

                    String resultado = api.buscarPersonajePorNombre(nombre);

                    if (resultado != null) {

                        String[] personajes = resultado.split("\"id\":");

                        for (int i = 1; i < personajes.length; i++) {

                            int pid = Integer.parseInt(personajes[i].split(",")[0]);

                            String nom = personajes[i].split("\"name\":\"")[1].split("\"")[0];
                            String estado = personajes[i].split("\"status\":\"")[1].split("\"")[0];
                            String especie = personajes[i].split("\"species\":\"")[1].split("\"")[0];

                            System.out.println("[" + pid + "] " + nom + " (" + estado + ", " + especie + ")");
                        }
                    }

                    break;

                case 3:

                    if (personajeActual != null && jsonActual != null) {


                        Gestion.guardarJsonPersonaje(personajeActual, jsonActual);
                    } else {

                        System.out.println("Primero debes buscar un personaje por ID");
                    }
                    break;

                case 4:

                    if (personajeActual != null) {

                        Gestion.descargarImagen(personajeActual);
                    } else {

                        System.out.println("Primero debes buscar un personaje por ID");
                    }
                    break;

                case 5:

                    System.out.print("Ruta local del archivo JSON: ");
                    String ruta = sc.nextLine();

                    System.out.print("Nombre con el que se subirá al FTP: ");
                    String nombreFTP = sc.nextLine();
                    FTPj.subirArchivo(ruta, nombreFTP);
                    break;

                case 6:

                    System.out.print("Nombre del archivo en el FTP: ");
                    String archivo = sc.nextLine();

                    System.out.print("Ruta local donde guardarlo: ");
                    String destino = sc.nextLine();

                    FTPj.descargarArchivo(archivo, destino);
                    break;

                case 7:

                    FTPj.listarArchivos();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
