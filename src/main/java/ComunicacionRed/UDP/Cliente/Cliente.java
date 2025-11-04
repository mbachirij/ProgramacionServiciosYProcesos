package ComunicacionRed.UDP.Cliente;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public static void main(String[] args) {

        final int PUERTO = 5000;

        byte[] buffer = new byte[1024];
        try {
            InetAddress direccion = InetAddress.getByName("localhost");

            //Creo el socket vacío
            DatagramSocket socketUDP = new DatagramSocket();
            String mensaje = "Hola desde el cliente";

            //Convierto el mensaje a bytes
            buffer = mensaje.getBytes();

            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccion, PUERTO);

            socketUDP.send(pregunta);

            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(peticion);
            System.out.println("Recibo la peticion");


            mensaje = new String(peticion.getData());
            System.out.println(mensaje);

            socketUDP.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
