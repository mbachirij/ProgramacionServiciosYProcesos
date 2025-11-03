package ComunicacionRed.Sockets.Cliente;

import java.io.IOException;
import java.net.UnknownHostException;

public class MainCliente {
    public static void main(String[] args) {

        Cliente cliente;
        String host = "localhost";
        int port = 54321;
        int contador = 0;

        try {
            for(int i=0; i<4; i++){
                cliente = new Cliente(host, port);
                System.out.println("Cliente "+ i +" abierto con el puerto " + port + " en el host " + host);
                Thread.sleep(2000);
            }
        }catch (UnknownHostException uh) {
            uh.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error de conexión. No se puede conectar al servidor");
            e.printStackTrace();
        }
    }
}
