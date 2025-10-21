package MultiHilos.Monjes;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
 * Crea un programa que ayude a los monjes de la abadía de Westfalia a
 * sincronizarse para orar y comer. Se crea una mesa donde X monjes rezan y comen.
 * Cuando están comiendo no están rezando, y cuando están rezando no están comiendo.
 * No pueden comer si el tenedor de la izquierda y derecha no están libres.
 */
public class Monasterio {

    private boolean[] tenedores;

    public Monasterio(int numMonjes){
        tenedores = new boolean[numMonjes];

    }

    public synchronized void intentaComer(int idMonje) throws InterruptedException{
        int izq = idMonje;
        int der = (idMonje+1)%tenedores.length;

        while(tenedores[izq] || tenedores[der]){
            wait();
        }

        tenedores[izq] = true;
        tenedores[der] = true;
        notifyAll();


    }

    public synchronized void soltarTenedor(int idMonje) throws InterruptedException{

        int izq = idMonje;
        int der = (idMonje+1)%tenedores.length;

        tenedores[izq] = false;
        tenedores[der] = false;
        notifyAll();
        System.out.println("El monje "+idMonje+" ha soltado el tenedor");

    }




}
