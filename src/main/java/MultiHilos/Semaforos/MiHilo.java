package MultiHilos.Semaforos;

import java.util.concurrent.Semaphore;

public class MiHilo implements Runnable{

    Semaphore semaphore;
    String nombre;

    public MiHilo(Semaphore semaphore, String nombre) {
        this.semaphore = semaphore;
        this.nombre = nombre;
    }


    @Override
    public void run() {

        System.out.println(nombre+" esperando a adquirir el semaforo");
        try {
            semaphore.acquire();
            System.out.println(nombre+" adquirido el semaforo");

            Thread.sleep(300);

            System.out.println(nombre+" ha liberado el semaforo");
            semaphore.release();

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


    }

}
