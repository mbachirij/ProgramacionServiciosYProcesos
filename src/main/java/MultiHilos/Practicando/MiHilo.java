package MultiHilos.Practicando;

public class MiHilo implements Runnable{

    @Override
    public void run(){
        System.out.println("Hola soy la clase MiHilo ejecutandose");
    }
}
