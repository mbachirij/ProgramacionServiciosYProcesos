package MultiHilos.Cafeteria;
/*
 * Esta clase sería el recurso compartido
 */
public class Cafetera {


    public synchronized void servirCafe(String nombre){

        System.out.println(nombre+" se quiere servir café");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nombre+" se ha terminadod e servir café");

    }

}
