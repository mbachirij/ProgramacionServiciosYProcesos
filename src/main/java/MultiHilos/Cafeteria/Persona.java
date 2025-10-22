package MultiHilos.Cafeteria;

public class Persona extends Thread {

    Cafetera cafetera;

    public Persona(String nombre, Cafetera cafetera) {
        super(nombre);
        this.cafetera = cafetera;
    }

    @Override
    public void run() {

        cafetera.servirCafe(this.getName());

    }

}
