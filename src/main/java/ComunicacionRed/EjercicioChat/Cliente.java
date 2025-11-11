package ComunicacionRed.EjercicioChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String servidorIP = "10.2.9.8";
        final int PUERTO = 7777;

        String mensaje = "";

        try {
            Socket socket = new Socket(servidorIP, PUERTO);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            while(true) {
                System.out.println("Escribe tu mensaje: ");
                mensaje = sc.nextLine();
                out.writeUTF(mensaje);

                if(mensaje.equals("Fin")){
                    break;
                }
            }


            socket.close();
            out.close();
            in.close();
            System.out.println("Fin del programa");


        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
