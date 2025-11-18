package ComunicacionRed.BorraPractica.tres;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
/*
 * Programa que permite ver la gente que se ha conectado al server
 * Creamos un cliente y servidor usando hilos en el cliente.
 * Cada vez que se conecta un cliente es un hilo.
 * El cliente se conecta al servidor. El servidor le pide el nombre.
 * El nombre que proporciona el cliente se guarda en un array del server
 */
public class Server {

    public static void main(String[] args) {
        ArrayList<String> clientes = new ArrayList<>();

        int puerto = 5000;

        try {
            ServerSocket servidor = new ServerSocket(puerto);
            while (true) {
                Socket socket = servidor.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress());

                new Thread(() -> {

                    try {
                        DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
                        DataInputStream entrada = new DataInputStream(socket.getInputStream());

                        salida.writeUTF("Escribe tu nombre: ");
                        String nombre = entrada.readUTF();

                        // Guardamos el nombre en la lista
                        synchronized (clientes) { //synchronized para que varios hilos no choquen
                            clientes.add(nombre);
                        }

                        System.out.println("Clientes conectados: " + clientes);

                        salida.writeUTF("Bienvenido "+nombre+". Ahora estas conectado al servidor.");

                        entrada.close();
                        salida.close();
                        socket.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
