package ComunicacionRed.EjercicioHilosSockets;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    public static List<String> tareasRegistradas = new ArrayList<>();

    public static void main(String[] args) {

        int puerto = 5000;

        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado en el puerto: " + puerto);

            while(true){
                Socket socket = servidor.accept();
                System.out.println("Cliente conectado desde "+socket.getInetAddress());


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
