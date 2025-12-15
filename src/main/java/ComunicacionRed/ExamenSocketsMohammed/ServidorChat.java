package ComunicacionRed.ExamenSocketsMohammed;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChat {

    public static void main(String[] args) {

        int puerto = 5000;

        System.out.println("Servidor iniciado en el puerto: " + puerto);

        try {
            // Crear el socket del servidor
            ServerSocket socket = new ServerSocket(puerto);

            while(true){
                // Esperar a que se conecte un cliente
                Socket socketCliente = socket.accept();
                System.out.println("Cliente conectado desde: " + socketCliente.getInetAddress());

                // Crear hilo para manejar el cliente
                new HiloCliente(socketCliente).start();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
