package ComunicacionRed.ExamenSocketsMohammed;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.net.Socket;

public class HiloCliente extends Thread{


    private DataOutputStream salida;
    private final Socket socket;
    private DataInputStream entrada;

    public HiloCliente(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){

        try {
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());

            while(true){
                String clave = entrada.readUTF();

                if(clave.equals("MSG")){
                    recibirMensaje();
                }else if(clave.equals("FILE")){
                    recibirArchivo();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Metodo para recibir un mensaje servidor
    public void recibirMensaje(){

        try {
            String mensaje = entrada.readUTF();
            System.out.println("Mensaje recibido: "+ mensaje);
            // Escribo el mensaje en un archivo texto
            FileWriter fw = new FileWriter("mensaje.txt", true);
            fw.write(mensaje+"\n");
            fw.close();

            salida.writeUTF("Mensaje recibido");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo para recibir un archivo servidor
    public void recibirArchivo(){

        try {
            String nombreArchivo = entrada.readUTF();
            long tamanoArchivo = entrada.readLong();

            FileOutputStream fos = new FileOutputStream(nombreArchivo);
            byte[] buffer = new byte[4092];

            int leido;
            while((leido = entrada.read(buffer)) != -1){
                fos.write(buffer, 0, leido);
            }


            System.out.println("Archivo "+nombreArchivo+" recibido correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
