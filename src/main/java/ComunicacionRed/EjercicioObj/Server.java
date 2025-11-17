package ComunicacionRed.EjercicioObj;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Server {
    public static void main(String[] args) {

        try {
            Socket socket = null;
            DataInputStream in;
            DataOutputStream out;
            int puerto = 5000;
            ServerSocket servidor = new ServerSocket(puerto);
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date hora = new Date();

            System.out.println("Servidor iniciado en el puerto "+ puerto +" esperando mensajes...");

            while(true){
                socket = servidor.accept();
                System.out.println("Cliente conectado desde "+socket.getInetAddress()+" a las "+ dateFormat.format(hora));
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());


                String mensaje = in.readUTF();
                System.out.println(mensaje);
            }

        } catch (Exception e) {
            System.out.println("Erroooooooorrr!!");
            e.printStackTrace();
        }


    }
}
