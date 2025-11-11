package ComunicacionRed.EnviarProfe;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        String servidorIP = "10.2.9.100";
        final int PUERTO = 5000;

        try (Socket socket = new Socket(servidorIP, PUERTO);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             DataInputStream in = new DataInputStream(socket.getInputStream())) {

            String mensaje = "Hola desde el cliente 9";
            out.writeUTF(mensaje);

            String mensajeRecibido = in.readUTF();
            System.out.println("Mensaje recibido: " + mensajeRecibido);

            socket.close();
            out.close();
            in.close();
            System.out.println("Fin del programa");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
