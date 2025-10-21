package MultiHilos.Imprenta;

public class Impresora {
    private int id;
    private boolean ocupada;

    public Impresora(int id) {
        this.id = id;
        this.ocupada = false;
    }

    public synchronized void imprimir(String nombre) throws InterruptedException {
        ocupada = true; //Está ocupada
        System.out.println(nombre+" está usando la impresora "+id);

            try {
                Thread.sleep(1000); // simula el tiempo de impresion
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(nombre+" ha terminado de usar la impresora "+id);
            ocupada = false;
            notifyAll();
    }

    public boolean isOcupada() {
        return ocupada;
    }
    public int getId(){
        return id;
    }
}
