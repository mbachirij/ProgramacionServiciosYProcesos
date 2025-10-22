package MultiHilos.Biblioteca;

public class Main {
    public static void main(String[] args) {

        Ordenador ordenador = new Ordenador();
        Estudiante e1 = new Estudiante("Mohammed", ordenador);
        Estudiante e2 = new Estudiante("Juan", ordenador);
        Estudiante e3 = new Estudiante("Eli", ordenador);
        Estudiante e4 = new Estudiante("Alberto", ordenador);
        Estudiante e5 = new Estudiante("Mario", ordenador);
        Estudiante e6 = new Estudiante("Alba", ordenador);
        Estudiante e7 = new Estudiante("Clara", ordenador);
        Estudiante e8 = new Estudiante("Leyre", ordenador);

        e1.start();
        e3.start();
        e2.start();
        e4.start();
        e5.start();
        e6.start();
        e7.start();
        e8.start();

    }
}
