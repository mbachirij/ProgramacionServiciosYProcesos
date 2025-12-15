package ServiciosRed.FTP;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import java.io.*;

public class Ejercicio1FTP {

    public static void main(String[] args) {

        FTPClient ftp = new FTPClient();

        try {
            // 1. Conectar
            ftp.connect("127.0.0.1", 21);

            // 2. Login
            boolean login = ftp.login("alumno", "1234");

            if (!login) {
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

            // 4. Crear directorio ejercicio1
            boolean creado = ftp.makeDirectory("ejercicio1");
            System.out.println(creado ? " Directorio creado" : "ℹ No se ha creado (puede que ya exista)");

            // 5. Crear archivo local alumno.txt
            FileWriter fw = new FileWriter("alumno.txt");
            fw.write("Nombre del alumno aquí");
            fw.close();

            // 6. Subir alumno.txt al servidor
            FileInputStream fis = new FileInputStream("alumno.txt");
            boolean subido = ftp.storeFile("ejercicio1/alumno.txt", fis);
            fis.close();

            System.out.println(subido ? "Archivo subido correctamente" : "Error al subir el archivo");

            // Cerrar sesión
            ftp.logout();
            ftp.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
