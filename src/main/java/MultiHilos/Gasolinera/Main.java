package MultiHilos.Gasolinera;

public class Main {
    public static void main(String[] args) {

        Gasolinera g = new Gasolinera();
        Coche c1 = new Coche("SEAT", g);
        Coche c2 = new Coche("BMW", g);
        Coche c3 = new Coche("VOLVO", g);
        Coche c4 = new Coche("CAMARO", g);
        Coche c5 = new Coche("AUDI", g);
        Coche c6 = new Coche("TESLA", g);
        Coche c7 = new Coche("PEUGEOT", g);
        Coche c8 = new Coche("VOLKSWAGEN", g);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();


    }
}
