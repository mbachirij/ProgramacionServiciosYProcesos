package ComunicacionRed.UDP.Servidor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Servidor {
    public static void main(String[] args) {

        final int PUERTO = 5000;
        byte[] bufferEnvio = new byte[1024];
        byte[] bufferRecibo = new byte[1024];


        System.out.println("Servidor iniciado");
        try {
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

            while(true){
                //Para preparar la respuesta
                DatagramPacket peticion = new DatagramPacket(bufferRecibo, bufferRecibo.length);

                // Recibo el datagrama
                socketUDP.receive(peticion);
                System.out.println("Recibo la info del cliente");
                String mensaje = new String(peticion.getData(), 0, peticion.getLength());
                System.out.println(mensaje);

                //Obtengo el puerto del cliente
                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();

                mensaje = "Hola son las: "+ LocalTime.now().format(dateFormat);
                bufferEnvio = mensaje.getBytes();

                //Ahora envío los datos
                DatagramPacket respuesta = new DatagramPacket(bufferEnvio, bufferEnvio.length, direccion, puertoCliente);
                System.out.println("Envío la infromación al cliente");
                // Envío el datagram
                socketUDP.send(respuesta);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
