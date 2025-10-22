package MultiHilos.Biblioteca;

public class Estudiante extends Thread {

    private String nombre;
    private Ordenador ordenador;

    public Estudiante(String nombre, Ordenador ordenador) {
        this.nombre = nombre;
        this.ordenador = ordenador;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        try {
            ordenador.usarOrdenador(getNombre());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
