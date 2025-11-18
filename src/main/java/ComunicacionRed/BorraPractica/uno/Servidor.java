package ComunicacionRed.BorraPractica.uno;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
    public static void main(String[] args) {

        int puerto = 5000;

        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor Iniciado");

            while (true) {
                Socket socket = servidor.accept();
                System.out.println("Cliente conectado");

                DataInputStream entrada = new DataInputStream(socket.getInputStream());
                DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

                String mensaje = entrada.readUTF();
                if(mensaje.equals("Fin")){break;}
                System.out.println("El mensaje del cliente es "+mensaje);

                salida.writeUTF("Mensaje recibido, confirmacion");
            }

        } catch (Exception e){
            System.out.println("Error en el servidor");
        }

    }
}
