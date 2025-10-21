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

    private Lock[] tenedores;

    public Monasterio(int numMonjes){
        tenedores = new Lock[numMonjes];
        for(int i=0; i<numMonjes; i++){
            tenedores[i] = new ReentrantLock();
        }
    }

    public boolean intentaComer(int idMonje){
        int izq = idMonje;
        int der = (idMonje+1)%tenedores.length;
        if(tenedores[izq].tryLock()){
            try{
                if(tenedores[der].tryLock()){
                    return true;
                }
            }finally{
                tenedores[izq].unlock();
            }
        }
        return false;
    }

    public void soltarTenedor(int idMonje){

        int izq = idMonje;
        int der = (idMonje+1)%tenedores.length;
        tenedores[izq].unlock();
        tenedores[der].unlock();

    }


}
