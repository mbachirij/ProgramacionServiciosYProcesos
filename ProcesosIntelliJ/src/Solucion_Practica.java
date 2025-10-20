import java.io.*;
import java.util.concurrent.TimeUnit;

public class Solucion_Practica {

    public static void main(String[] args){

        try {

            ProcessBuilder processBuilder = new ProcessBuilder("ping", args[0]);



            // processBuilder.redirectOutput(ping);

            // Iniciar el proceso
            Process proceso = processBuilder.start();

            // Obtener el flujo de entrada del proceso
            InputStream inputStream = proceso.getInputStream();

            // Leer la salida del proceso y mostrarla en la consola
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String linea;
            reader.readLine(); // La primera linea da error.
            linea = reader.readLine();
            String[] palabras = linea.split(" ");
            System.out.println(palabras[4]);
            FileWriter fr = new FileWriter(args[1]);
            fr.write(palabras[4]);
            fr.close();
            inputStream.close();

            // Esperar a que el proceso termine
            int salida = proceso.waitFor();

            if (salida == 0) {
                ProcessBuilder otroProcesoBuilder = new ProcessBuilder("mspaint.exe");
                Process otroProceso = otroProcesoBuilder.start();
                otroProceso.waitFor(5, TimeUnit.SECONDS);
                otroProceso.destroy();
                System.out.println("Se cierra Paint");

            }
        } catch (IOException | InterruptedException e) {

            e.printStackTrace();
        }


    }

}
