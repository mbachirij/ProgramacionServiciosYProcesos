package MultiHilos.Biblioteca;

import java.util.concurrent.Semaphore;

public class Ordenador {

    Semaphore semaphore = new Semaphore(5);

    public void usarOrdenador(String nombre) throws InterruptedException{

        try {
            semaphore.acquire(); //Pide permiso para usar el ordenador
            System.out.println(nombre+" entra a usar el ordenador");
            Thread.sleep(1500);
            System.out.println(nombre+" termina a usar el ordenador");
        } finally {
            semaphore.release(); //libera el ordeandor
        }

    }

}
