package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException{
        //Inicializamos el pool con 4 hilos activos
        ExecutorService executor = Executors.newFixedThreadPool(4);

        //Generamos 100 hilos
        for(int i=0; i<100; i++){
            executor.execute(new Hilo(i));
        }

        //Cierra la piscina de hilos
        executor.shutdown();

    }



}
