package MultiHilos.CarnSemaphore;

/*
 * Tienes 3 clientes (Cliente) que van a comprar a una Carnicería (Carniceria).
 * Solo 1 carnicero atiende a la vez, así que solo un cliente puede estar siendo atendido.
 * Usaremos un Semaphore con 1 permiso.
 */

import java.util.concurrent.Semaphore;

public class Carniceria {

    Semaphore semaphore = new Semaphore(2);


    public void comprar(String nombre){

        try {
            semaphore.acquire(); //Pide permiso
            System.out.println("Entra a la carnicería " + nombre);

            Thread.sleep(1000);
            System.out.println("Cliente "+nombre+" ha terminado de comprar");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); //Libera el permiso
        }
    }


}
