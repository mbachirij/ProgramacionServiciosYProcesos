package ComunicacionRed.Sockets.Cliente;

import java.io.IOException;
import java.net.Socket;

public class Cliente extends Thread {

    private int PORT;
    private String HOST;
    private Socket socket;

    public Cliente(String HOST, int PORT) throws IOException {
        this.HOST = HOST;
        this.PORT = PORT;
        this.socket = new Socket(HOST, PORT);
    }

}
