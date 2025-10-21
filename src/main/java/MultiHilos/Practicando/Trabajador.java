package MultiHilos.Practicando;

public class Trabajador extends Thread{

    private String nombre;
    private Impresora impresora;

    public Trabajador(String nombre, Impresora impresora) {
        this.nombre = nombre;
        this.impresora = impresora;
    }

    @Override
    public void run() {
        impresora.imprimir(nombre);
    }

}
