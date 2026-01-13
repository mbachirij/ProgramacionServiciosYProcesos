package ServiciosRed.RickMorty;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FTPj {

    private static final String SERVIDOR = "localhost";
    private static final String USUARIO = "usuario";
    private static final String PASSWORD = "password";

    // Sube un archivo al FTP
    public static void subirArchivo(String rutaLocal, String nombreRemoto) {

        FTPClient ftp = new FTPClient();

        try (FileInputStream fis = new FileInputStream(rutaLocal)) {

            ftp.connect(SERVIDOR);
            ftp.login(USUARIO, PASSWORD);
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            boolean subido = ftp.storeFile(nombreRemoto, fis);

            if (subido) {
                System.out.println("Archivo subido correctamente al FTP");
            } else {
                System.out.println("No se pudo subir el archivo");
            }

            ftp.logout();
            ftp.disconnect();

        } catch (IOException e) {
            System.out.println("Error al subir el archivo al FTP");
        }
    }

    // Lista los archivos del directorio raíz del FTP
    public static void listarArchivos() {

        FTPClient ftp = new FTPClient();

        try {
            ftp.connect(SERVIDOR);
            ftp.login(USUARIO, PASSWORD);
            ftp.enterLocalPassiveMode();

            String[] archivos = ftp.listNames();

            if (archivos != null && archivos.length > 0) {
                System.out.println("Archivos en el FTP:");
                for (String nombre : archivos) {
                    System.out.println("- " + nombre);
                }
            } else {
                System.out.println("No hay archivos en el FTP");
            }

            ftp.logout();
            ftp.disconnect();

        } catch (IOException e) {
            System.out.println("Error al listar archivos del FTP");
        }
    }

    // Descarga un archivo del FTP
    public static void descargarArchivo(String nombreRemoto, String rutaLocal) {

        FTPClient ftp = new FTPClient();

        try (FileOutputStream fos = new FileOutputStream(rutaLocal)) {

            ftp.connect(SERVIDOR);
            ftp.login(USUARIO, PASSWORD);
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            boolean descargado = ftp.retrieveFile(nombreRemoto, fos);

            if (descargado) {
                System.out.println("Archivo descargado correctamente");
            } else {
                System.out.println("No se pudo descargar el archivo");
            }

            ftp.logout();
            ftp.disconnect();

        } catch (IOException e) {
            System.out.println("Error al descargar el archivo del FTP");
        }
    }
}
