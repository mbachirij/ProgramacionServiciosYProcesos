package ServiciosRed.FTP;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoFTP {

    public static void main(String[] args) {

        FTPClient ftp = new FTPClient();

        try {
            System.out.println("Conectando al servidor FTP...");
            ftp.connect("127.0.0.1", 21);

            boolean login = ftp.login("alumno", "1234");

            if (!login) {
                System.out.println(" Error de login");
                return;
            }

            ftp.enterLocalPassiveMode();
            System.out.println(" Conexión establecida correctamente\n");

            // --- LISTAR ARCHIVOS ---
            System.out.println("Archivos en el servidor:");
            FTPFile[] archivos = ftp.listFiles();
            for (FTPFile f : archivos) {
                System.out.println(" - " + f.getName());
            }

            // --- DESCARGAR ARCHIVO ---
            System.out.println("\nDescargando 'bienvenida.txt'...");

            FileOutputStream fos = new FileOutputStream("bienvenida_descargado.txt");
            boolean ok = ftp.retrieveFile("bienvenida.txt", fos);
            fos.close();

            if (ok) {
                System.out.println(" Archivo descargado correctamente.");
            } else {
                System.out.println(" Error al descargar el archivo.");
            }

            ftp.logout();
            ftp.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
