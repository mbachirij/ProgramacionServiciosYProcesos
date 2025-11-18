package ComunicacionRed.BorraPractica.uno;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        int puerto = 5000;
        String host = "localhost";

        try {
            Socket socket = new Socket(host, puerto);
            System.out.println("Cliente conectado");

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            String mensaje = "Hola servidor soy el cliente conectado";
            salida.writeUTF(mensaje);

            String respuesta = entrada.readUTF();
            System.out.println("La respuesta del servidor es: "+respuesta);

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
