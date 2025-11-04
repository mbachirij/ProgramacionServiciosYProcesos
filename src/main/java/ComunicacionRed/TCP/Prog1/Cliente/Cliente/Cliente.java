package ComunicacionRed.TCP.Prog1.Cliente.Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente extends Thread {

    public static void main(String[] args) {
        int PORT = 54321;
        String HOST = "localhost";
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        try {

            socket = new Socket(HOST, PORT);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

            out.writeUTF("Hola desde el cliente");
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            socket.close();

        }catch(UnknownHostException uhe){
            uhe.printStackTrace();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}