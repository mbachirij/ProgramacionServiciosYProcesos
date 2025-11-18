package ComunicacionRed.Archivo.ServidorArchivo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorArchivo {

    public static void main(String[] args) {

        int puerto = 5000;

        try{
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto: " + puerto);
            Socket socket = servidor.accept();
            System.out.println("Cliente conectado desde "+socket.getInetAddress());

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            //Recibir nombre del archivo solicitado
            String nombreArchivo = entrada.readUTF();
            System.out.println("El cliente solicita el archivo: " + nombreArchivo);

            File archivo = new File(nombreArchivo);

            if(!archivo.exists()){
                salida.writeLong(-1); // Indicamos que no existe
                System.out.println("Archivo no encontrado");
                socket.close();
            }

            long tamano = archivo.length();

            FileInputStream fis = new FileInputStream(archivo);
            byte[] buffer = new byte[9096];
            int bytesLeidos;


            while((bytesLeidos = fis.read(buffer))!=-1){
                salida.write(buffer, 0, bytesLeidos);
            }
            fis.close();
            socket.close();
            System.out.println("Archivo enviado");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
