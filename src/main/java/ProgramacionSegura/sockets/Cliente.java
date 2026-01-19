package ProgramacionSegura.sockets;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import javax.crypto.SecretKey;

public class Cliente {

    public static void main(String[] args) {

        try {
            SecretKey clave = CryptoUtils.generarClave();

            Socket socket = new Socket("localhost", 5000);
            DataOutputStream salida =
                    new DataOutputStream(socket.getOutputStream());

            // 1️⃣ Enviar clave
            String claveBase64 = CryptoUtils.claveToBase64(clave);
            salida.writeUTF(claveBase64);

            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce el mensaje: ");
            String mensaje = sc.nextLine();

            // 2️⃣ Enviar mensaje cifrado
            String mensajeCifrado = CryptoUtils.cifrar(mensaje, clave);
            salida.writeUTF(mensajeCifrado);

            System.out.println("Clave enviada: " + claveBase64);
            System.out.println("Mensaje cifrado enviado: " + mensajeCifrado);

            socket.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
