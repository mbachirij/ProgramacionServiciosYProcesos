package MultiHilos.CarnSemaphore;

public class Persona extends Thread{

    private Carniceria carniceria;

    public Persona(String nombre, Carniceria carniceria){
        super(nombre);
        this.carniceria = carniceria;
    }

    public void run(){
        carniceria.comprar(this.getName());
    }

}
