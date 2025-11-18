package ComunicacionRed.BorraPractica.tres;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
/*
 * Programa que permite ver la gente que se ha conectado al server
 * Creamos un cliente y servidor usando hilos en el cliente.
 * Cada vez que se conecta un cliente es un hilo.
 * El cliente se conecta al servidor. El servidor le pide el nombre.
 * El nombre que proporciona el cliente se guarda en un array del server
 */
public class Cliente {
    public static void main(String[] args) {

        String host = "localhost";
        int puerto = 5000;

        try {
            Socket socket = new Socket(host, puerto);
            System.out.println("Cliente conectado");

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);

            String mensaje = entrada.readUTF();
            System.out.println(mensaje);

            System.out.print("Tu nombre: ");
            String nombre = sc.nextLine();
            salida.writeUTF(nombre);

            String respuesta = entrada.readUTF();
            System.out.println(respuesta);

            entrada.close();
            salida.close();
            socket.close();
            sc.close();


        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
