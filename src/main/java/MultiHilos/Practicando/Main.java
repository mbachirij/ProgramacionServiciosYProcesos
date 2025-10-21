package MultiHilos.Practicando;

public class Main {
    public static void main(String[] args) {

        Hilo hilo = new Hilo();
        Thread h1 = new Thread(new MiHilo());
        miPrimerHilo h2 = new miPrimerHilo("Mohammed");
        miPrimerHilo h3 = new miPrimerHilo("Eduardo");
        miPrimerHilo h4 = new miPrimerHilo("Luiz");

        hilo.start();
        h1.start();
        System.out.println();
        h2.start();
        h3.start();
        h4.start();

    }
}
