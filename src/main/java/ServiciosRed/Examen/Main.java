package ServiciosRed.Examen;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ChuckApiClient api = new ChuckApiClient();
        FileManager fileManager = new FileManager();
        FtpManager ftp = new FtpManager();

        int opcion;

        do {
            System.out.println("\n=== CHUCK NORRIS CLIENT ===");
            System.out.println("1. Listar categorías");
            System.out.println("2. Obtener chiste aleatorio");
            System.out.println("3. Obtener chiste por categoría");
            System.out.println("4. Guardar y subir chiste (JSON por categoría)");
            System.out.println("5. Listar archivos FTP");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    // TODO: llamar al método que lista las categorías
                    System.out.println("Listado de Categorías:");
                    api.listarCategorias();
                    break;

                case 2:
                    // TODO: obtener un chiste aleatorio desde la API
                    break;

                case 3:
                    System.out.print("Introduce categoría: ");
                    String categoria = sc.nextLine();
                    // TODO: obtener chiste por categoría
                    break;

                case 4:
                    /*
                     * TODO:
                     * 1. Obtener la categoría del último chiste
                     * 2. Si no tiene categoría, mostrar mensaje y salir
                     * 3. Guardar el chiste en el JSON de ESA categoría
                     * 4. Subir ese JSON al FTP dentro del directorio de la categoría
                     */
                    break;

                case 5:
                    // TODO: listar archivos y directorios del FTP
                    System.out.println("Listado de archivos:");
                    ftp.listarArchivos();
                    break;

                case 0:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
