package ComunicacionRed.UDP.Servidor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {
    public static void main(String[] args) {

        final int PUERTO = 5000;
        byte[] buffer = new byte[1024];

        System.out.println("Servidor iniciado");
        try {
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);

            while(true){
                //Para preparar la respuesta
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                // Recibo el datagrama
                socketUDP.receive(peticion);
                System.out.println("Recibo la info del cliente");
                String mensaje = new String(peticion.getData());

                //Obtengo el puerto del cliente
                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();

                mensaje = "Hola desde el servidor";
                buffer = mensaje.getBytes();

                //Ahora envío los datos
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
                System.out.println("Envío la infromación al cliente");
                // Envío el datagram
                socketUDP.send(respuesta);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
