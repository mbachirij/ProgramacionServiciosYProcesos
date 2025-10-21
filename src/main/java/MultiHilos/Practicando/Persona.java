package MultiHilos.Practicando;

public class Persona extends Thread{

    private Cuenta cuenta;

    public Persona(String nombre, Cuenta cuenta) {
        super(nombre);
        this.cuenta = cuenta;
    }

    @Override
    public void run() {

        cuenta.retirarDinero(this.getName(), 50);

    }

}
