package ComunicacionRed.TCP.Calculadora.Cliente;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

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

    public static String operacion(String a){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿QUÉ OPERACIÓN VA A REALIZAR EL CLIENTE?");
        System.out.println("1. SUMA");
        System.out.println("2. RESTA");
        System.out.println("3. MULTIPLICACIÓN");
        System.out.println("4. DIVISION");
        String opcion = sc.nextLine().trim();
        return opcion;
    }

}
