package MultiHilos.Carniceria;

public class Cliente extends Thread{
    private String nombre;
    private Carniceria carniceria;

    public Cliente(String nombre, Carniceria carniceria){
        this.nombre = nombre;
        this.carniceria = carniceria;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Carniceria getCarniceria() {
        return carniceria;
    }
    public void setCarniceria(Carniceria carniceria) {
        this.carniceria = carniceria;
    }



    @Override
    public void run(){
        try {
            System.out.println("El cliente " + this.nombre + " ha entrado a la carniceria");

            carniceria.pedirCarne(this);
            carniceria.pagar(this);
            carniceria.despedirse(this);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
