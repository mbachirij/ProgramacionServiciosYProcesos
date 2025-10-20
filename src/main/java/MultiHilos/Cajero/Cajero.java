package MultiHilos.Cajero;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cajero {
    private static double saldo = 1000.00;
    private static Lock lock = new ReentrantLock();

    public static void main (String[] args){

        Thread t1 = new Thread(()->{
            realizarRetiro(500.00);
        });
        Thread t2 = new Thread(()->{
            realizarRetiro(700.00);
        });
        t1.start();
        t2.start();



    }

    public static void realizarRetiro(double cantidad){

        lock.lock();

        try {
            if(saldo >= cantidad){
                saldo = saldo - cantidad;
                System.out.println("Retiro exitoso");
            } else {
                System.out.println("Saldo insuficiente");
            }
        } finally {
            lock.unlock();
        }


    }

}
