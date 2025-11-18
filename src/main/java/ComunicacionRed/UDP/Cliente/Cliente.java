package ComunicacionRed.UDP.Cliente;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public static void main(String[] args) {

        final int PUERTO = 5000;
        byte[] bufferEnvio = new byte[1024];
        byte[] bufferRecibo = new byte[1024];

        try {
            InetAddress direccion = InetAddress.getByName("localhost");

            //Creo el socket vacío
            DatagramSocket socketUDP = new DatagramSocket();

            String mensaje = "Hola desde el cliente";

            //Convierto el mensaje a bytes
            bufferEnvio = mensaje.getBytes();

            DatagramPacket pregunta = new DatagramPacket(bufferEnvio, bufferEnvio.length, direccion, PUERTO);

            socketUDP.send(pregunta);

            DatagramPacket peticion = new DatagramPacket(bufferRecibo, bufferRecibo.length);
            socketUDP.receive(peticion);
            System.out.println("Recibo la peticion");


            mensaje = new String(peticion.getData(), 0, peticion.getLength());
            System.out.println(mensaje);

            socketUDP.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
