package ProgramacionSegura.sockets;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.crypto.SecretKey;

public class Servidor {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Servidor esperando conexión...");

            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado");

            DataInputStream entrada =
                    new DataInputStream(socket.getInputStream());

            // 1️⃣ Recibir clave
            String claveBase64 = entrada.readUTF();
            SecretKey clave = CryptoUtils.base64ToClave(claveBase64);

            // 2️⃣ Recibir mensaje cifrado
            String mensajeCifrado = entrada.readUTF();
            System.out.println("Mensaje cifrado recibido: " + mensajeCifrado);

            String mensajeDescifrado =
                    CryptoUtils.descifrar(mensajeCifrado, clave);

            System.out.println("Mensaje descifrado: " + mensajeDescifrado);

            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
