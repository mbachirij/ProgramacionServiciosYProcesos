package ComunicacionRed.Archivo.ClienteArchivo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class ClienteArchivo {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;
        String nombreArchivo = "prueba.txt";

        try {
            Socket socket = new Socket(host, port);

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            //Envio el nombre del archivo que quiero abrir
            salida.writeUTF(nombreArchivo);

            long tamano = entrada.readLong();
            if(tamano == -1){
                System.out.println("El servidor indica que el archivo no existe");
                return;
            }
            System.out.println("Recibiendo archivo del tamaño... "+tamano);

            FileOutputStream fos = new FileOutputStream("copia_"+nombreArchivo);

            byte[] buffer = new byte[4096];
            long bytesRecibidos = 0;
            int bytesLeidos;

            while(bytesRecibidos < tamano &&(bytesLeidos = entrada.read(buffer)) != -1){
                fos.write(buffer, 0, bytesLeidos);
                bytesRecibidos += bytesLeidos;
            }
            fos.close();
            System.out.println("Archivo recibido y guardado como copia_prueba.txt");



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
