package MultiHilos.CarnSemaphore;

public class Main {
    public static void main(String[] args) {

        Carniceria carniceria = new Carniceria();
        Persona p1 = new Persona("moha", carniceria);
        Persona p2 = new Persona("alberto", carniceria);
        Persona p3 = new Persona("juan", carniceria);
        Persona p4 = new Persona("Christian", carniceria);

        p1.start();
        p2.start();
        p3.start();
        p4.start();


    }
}
