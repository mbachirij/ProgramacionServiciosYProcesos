package ComunicacionRed.BorraPractica.dos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        int puerto = 5000;

        try {
            ServerSocket servidor = new ServerSocket(puerto);

            while(true){
                System.out.println("Servidor conectado, Esperando mensaje...");
                Socket socket = servidor.accept();
                DataInputStream entrada = new DataInputStream(socket.getInputStream());
                DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

                String mensaje = entrada.readUTF();
                System.out.println(mensaje);

                salida.writeUTF("Mensaje recibido");

            }

        } catch (Exception e){
            System.out.println("Error en el servidor");
        }
    }

}
