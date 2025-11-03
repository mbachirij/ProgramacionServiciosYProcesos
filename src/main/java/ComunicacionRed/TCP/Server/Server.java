package ComunicacionRed.TCP.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
         
         Socket sc = null;
         DataOutput out;
         DataInput in;
         final int PORT = 54321;
        ServerSocket servidor = new ServerSocket(PORT);

         while(true){
             sc = servidor.accept();

             System.out.println("Cliente conectado");
             in = new DataInputStream(sc.getInputStream());
             out = new DataOutputStream(sc.getOutputStream());

             //Leo lo que me manda el cliente
             String mensaje = in.readUTF();

             //Enviamos un mensaje al cliente
             out.writeUTF("Bienvenido al servidor ");
         }
    }
}
