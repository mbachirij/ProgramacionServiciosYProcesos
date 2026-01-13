package ServiciosRed.Examen;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FtpManager {

    private static final String SERVER = "localhost";
    private static final String USER = "alumno";
    private static final String PASS = "1234";

    public void subirJsonPorCategoria(String archivo, String categoria) {

        /*
         * TODO:
         * 1. Conectarse al servidor FTP
         * 2. Autenticarse
         * 3. Entrar en modo pasivo
         * 4. Crear el directorio remoto con el nombre de la categoría (si no existe)
         * 5. Cambiar al directorio de la categoría //changeWorkingDirectory(categoria);
         * 6. Subir el archivo JSON
         * 7. Cerrar correctamente la conexión
         */
        FTPClient ftp = new FTPClient();
        try {

            ftp.connect(SERVER);

            if(ftp.login(USER, PASS)){

                // Entrar en modo pasivo
                ftp.enterLocalPassiveMode();
                ftp.setFileType(FTPClient.BINARY_FILE_TYPE);


                // Crear directorio remoto
                ftp.makeDirectory(categoria);
                // Cambiar al directorio remoto
                ftp.changeWorkingDirectory(categoria);
                // Subir archivo JSON
                boolean subido = ftp.storeFile(archivo, new java.io.FileInputStream(archivo));
                System.out.println(subido ? "Archivo subido correctamente" : "Error al subir el archivo");


                ftp.logout();
                ftp.disconnect();
            } else {
                System.out.println("Error al autenticarse");
            }


        } catch (Exception e) {
           System.out.println("Error FTP"+e.getMessage());
        }
    }

    public void listarArchivos() {

        /*
         * TODO:
         * 1. Conectarse al servidor FTP
         * 2. Autenticarse
         * 3. Listar archivos y directorios
         * 4. Mostrar sus nombres por pantalla
         * 5. Cerrar correctamente la conexión
         */
        FTPClient ftp = new FTPClient();
        try {
        ftp.connect(SERVER);
        if(ftp.login(USER, PASS)) {

            System.out.println("Archivos iniciales en el servidor:");
            for (FTPFile f : ftp.listFiles()) {
                System.out.println(" - " + f.getName());
            }

        } else {
            System.out.println("Error al autenticarse");
        }

        ftp.logout();
        ftp.disconnect();

        } catch (Exception e) {
            System.out.println("Error FTP"+e.getMessage());
        }

    }
}
