package MultiHilos.CarniceriaSemaforos;

import MultiHilos.Carniceria.Cliente;

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
