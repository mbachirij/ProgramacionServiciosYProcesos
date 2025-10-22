package Semaforos;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args){

        Semaphore semaphore = new Semaphore(1);
        Thread hilo1 = new Thread(new MiHilo(semaphore, "Hilo1"));
        Thread hilo2 = new Thread(new MiHilo(semaphore, "Hilo2"));
        Thread hilo3 = new Thread(new MiHilo(semaphore, "Hilo3"));

        hilo1.start();
        hilo2.start();
        hilo3.start();



    }

}
