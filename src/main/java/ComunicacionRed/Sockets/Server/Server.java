package ComunicacionRed.Sockets.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private final int PORT = 54321;
    private int cont = 0;

    public Server() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
    }
    /*
     * Tiene que esperar 5 segundos para que se conecten 5 clientes.
     */
    public void esperarConexion() throws IOException{
        while(true){
            System.out.println("Esperando conexiones de los clientes");
            Socket socket = serverSocket.accept();
            System.out.println("Se ha conectado un cliente");
            System.out.println("Adiós");
        }
    }
}
