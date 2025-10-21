package MultiHilos.Practicando;

public class MainImprenta {
    public static void main(String[] args) {

        Impresora impresora = new Impresora();
        Trabajador t1 = new Trabajador("Mohammed", impresora);
        Trabajador t2 = new Trabajador("Mike", impresora);
        Trabajador t3 = new Trabajador("Mario", impresora);

        t1.start();
        t2.start();
        t3.start();

    }
}
