package ComunicacionRed.Sockets.Server;

import java.io.IOException;

public class MainServer {

    public static void main(String[] args) {

        Server server;
        try {
            server = new Server();
            while(true){
                server.esperarConexion();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
