package ComunicacionRed.BorraPractica.dos;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {

        String  host = "localhost";
        int puerto = 5000;

        try {
            Socket socket = new Socket(host, puerto);
            System.out.println("Conectado");

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            salida.writeUTF("Hola soy el cliente "+ socket.getInetAddress());

            String respuesta = entrada.readUTF();
            System.out.println("Respuesta: " + respuesta);

            entrada.close();
            salida.close();
            socket.close();


        } catch (Exception e) {
            System.out.println("Error en el cliente");
        }

    }
}
