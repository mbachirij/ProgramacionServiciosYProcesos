package ComunicacionRed.ExamenSocketsMohammed;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteChat {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 5000);
        DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Enviar mensaje\n2. Enviar archivo");
        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar

        if (opcion == 1) {

            salida.writeUTF("MSG");
            System.out.print("Escribe el mensaje: ");
            String msg = sc.nextLine();
            salida.writeUTF(msg);

        } else if (opcion == 2) {

            salida.writeUTF("FILE");
            System.out.print("Ruta del archivo: ");
            String ruta = sc.nextLine();
            File archivo = new File(ruta);
            salida.writeUTF(archivo.getName());
            salida.writeLong(archivo.length());

            FileInputStream fis = new FileInputStream(archivo);
            byte[] buffer = new byte[4096];
            int leido;
            while ((leido = fis.read(buffer)) != -1) {
                salida.write(buffer, 0, leido);
            }
            fis.close();
            System.out.println("Archivo enviado correctamente.");
        }

        socket.close();
    }
}
