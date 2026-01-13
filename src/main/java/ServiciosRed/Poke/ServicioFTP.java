package ServiciosRed.Poke;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ServicioFTP {

    // 1. Configuración FIJA para tu examen
    private static final String SERVER = "127.0.0.1";
    private static final int PORT = 21;
    private static final String USER = "alumno";
    private static final String PASS = "1234";

    // --- SUBIR ARCHIVO (Lógica Robusta) ---
    public static void subirArchivo(String rutaLocal, String nombreRemoto) {
        FTPClient ftp = new FTPClient();
        FileInputStream fis = null;

        try {
            System.out.println("Conectando a " + SERVER + " para SUBIR...");
            ftp.connect(SERVER, PORT);

            if (!ftp.login(USER, PASS)) {
                System.out.println("Error: Login incorrecto.");
                return;
            }

            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            fis = new FileInputStream(rutaLocal);
            boolean subido = ftp.storeFile(nombreRemoto, fis);

            if (subido) {
                System.out.println("--> ÉXITO: Archivo subido como " + nombreRemoto);
            } else {
                System.out.println("--> ERROR: No se pudo subir.");
            }

            ftp.logout();

        } catch (IOException e) {
            System.out.println("Error FTP al subir: " + e.getMessage());
        } finally {
            // CIERRE DE SEGURIDAD
            try {
                if (fis != null) fis.close();
                if (ftp.isConnected()) ftp.disconnect();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // --- DESCARGAR ARCHIVO (Lógica Robusta Corregida) ---
    public static void descargar(String nombreRemoto, String rutaLocal) {
        FTPClient ftp = new FTPClient();
        FileOutputStream fos = null;

        try {
            System.out.println("Conectando a " + SERVER + " para DESCARGAR...");
            ftp.connect(SERVER, PORT);

            if (!ftp.login(USER, PASS)) {
                System.out.println("Error: Login incorrecto.");
                return;
            }

            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            fos = new FileOutputStream(rutaLocal);
            boolean descargado = ftp.retrieveFile(nombreRemoto, fos);

            if (descargado) {
                System.out.println("--> ÉXITO: Archivo descargado en " + rutaLocal);
            } else {
                System.out.println("--> ERROR: No se pudo descargar (¿Existe el archivo remoto?).");
            }

            ftp.logout();

        } catch (IOException e) {
            System.out.println("Error FTP al descargar: " + e.getMessage());
        } finally {
            // CIERRE DE SEGURIDAD (Igual que en subir)
            try {
                if (fos != null) fos.close();
                if (ftp.isConnected()) ftp.disconnect();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}