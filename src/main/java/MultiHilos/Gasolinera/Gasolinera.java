package MultiHilos.Gasolinera;

import java.util.concurrent.Semaphore;

public class Gasolinera {

    private Semaphore surtidores = new Semaphore(3);
    private Coche coche;

    public void repostar(String nombre){
        try {


            surtidores.acquire();
            System.out.println("Coche "+nombre+" repostando en gasolinera");
            Thread.sleep((int)(Math.random()*3000));

            System.out.println("Coche "+nombre+" ha terminado de repostar");
            surtidores.release();

            System.out.println(surtidores.availablePermits()+" Surtidores libres.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
