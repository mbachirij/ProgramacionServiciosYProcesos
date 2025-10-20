package MultiHilos.Carniceria;

/*
Realizar un programa que simule la compra  en una carnicería utilizando un objeto Lock.

•	Varios clientes entran en una carnicería a comprar carne. Sólo hay un carnicero que atiende a los clientes.
•	Se generan 8 clientes de los cuales sólo 4 pueden estar en ejecución.

•	Un cliente entra en la carnicería, pide carne, paga y se va.
•	El método pedirCarne  Muestra un mensaje indicando “El cliente X ha pedido 2kg de chuletas de cordero”
•	El método pagar  Muestra un mensaje indicando “El cliente X ha pagado su pedido”
•	El método despedirse  Muestra un mensaje indicando “ Hasta luego”.
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Carniceria {
    private  int id;
    private Lock lock;

    public Carniceria(int id) {
        this.id = id;
        lock = new ReentrantLock();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Lock getLock() {
        return lock;
    }
    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public void pedirCarne(Cliente cliente) throws InterruptedException{
        lock.lock();
        System.out.println("El cliente "+cliente.getNombre()+" está pidiendo 2kg de carne");
        Thread.sleep(2000);
        lock.unlock();
        System.out.println("El cliente "+cliente.getNombre()+" ha dejado de pedir");
    }

    public void pagar(Cliente cliente) throws InterruptedException{
        lock.lock();
        System.out.println("El cliente "+cliente.getNombre()+" ha pagado su pedido");
        Thread.sleep(2000);
        lock.unlock();
        System.out.println("El cliente "+cliente.getNombre()+" ha dejado de pagar");
    }
    public void despedirse(Cliente cliente) throws InterruptedException{
        lock.lock();
        System.out.println("El cliente "+cliente.getNombre()+" se está despidiendo");
        Thread.sleep(2000);
        lock.unlock();
        System.out.println("El cliente "+cliente.getNombre()+" ha dejado la carnicería");
    }

}
