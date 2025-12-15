package ServiciosRed.FTP;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import java.io.*;

public class Ejercicio2FTP {

    public static void main(String[] args) {

        FTPClient ftp = new FTPClient();

        try {

            // 1. Conectar
            ftp.connect("127.0.0.1", 21);

            // 2. Iniciar sesión
            boolean login = ftp.login("alumno", "1234");

            if(!login){
                System.out.println("Error de login");
                return;
            }

            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

            // 3. Listar archivos del servidor
            System.out.println("Archivos iniciales en el servidor:");
            for (FTPFile f : ftp.listFiles()) {
                System.out.println(" - " + f.getName());
            }

            // 4. Subir prueba.txt al servidor
            FileInputStream fis = new FileInputStream("prueba.txt");
            boolean subido = ftp.storeFile("prueba.txt", fis);
            fis.close();
            System.out.println(subido ? "Archivo subido correctamente" : "Error al subir el archivo");

            // 5. Renombra el archivo subido
            boolean renombrado = ftp.rename("prueba.txt", "renombrado.txt");
            System.out.println( renombrado ? "Archivo renombrado correctamente" : "Error al renombrar el archivo");

            // 6. Descarga renombrado.txt como descargado.txt
            FileOutputStream fos = new FileOutputStream("descargado.txt");
            ftp.retrieveFile("renombrado.txt", fos);
            fos.close();

            // 7. Borra renombrado.txt del servidor
            //boolean borrado = ftp.deleteFile("renombrado.txt");
            //System.out.println(borrado ? "Archivo borrado correctamente" : "Error al borrar el archivo");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ESTO ES LO IMPORTANTE:
            // El disconnect debe ir SIEMPRE en el finally.
            // Si tu programa falla en la línea 20, tu código actual nunca llegaría a desconectarse.
            try {
                if (ftp.isConnected()) {
                    ftp.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
