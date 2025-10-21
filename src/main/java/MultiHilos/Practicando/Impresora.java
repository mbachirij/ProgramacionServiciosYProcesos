package MultiHilos.Practicando;

public class Impresora {

    public synchronized void imprimir(String nombre){

        System.out.println(nombre+" quiere imprimir");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nombre+" ya ha imprimido");
    }

}
