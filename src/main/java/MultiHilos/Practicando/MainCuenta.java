package MultiHilos.Practicando;

public class MainCuenta {
    public static void main(String[] args) {

        Cuenta cuenta = new Cuenta();
        Persona p1 = new Persona("Mohammed", cuenta);
        Persona p2 = new Persona("Alejandro", cuenta);
        Persona p3 = new Persona("Marcos", cuenta);

        p1.start();
        p2.start();
        p3.start();

    }
}
