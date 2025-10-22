package MultiHilos.Cafeteria;

public class MAin {
    public static void main(String[] args) {

        Cafetera c = new Cafetera();
        Persona p1 = new Persona("moha", c);
        Persona p2 = new Persona("jonas", c);
        Persona p3 = new Persona("john", c);

        p1.start();
        p2.start();
        p3.start();

    }
}
