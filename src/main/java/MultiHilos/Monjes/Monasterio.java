package MultiHilos.Monjes;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
