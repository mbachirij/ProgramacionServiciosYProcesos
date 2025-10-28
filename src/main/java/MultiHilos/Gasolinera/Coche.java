package MultiHilos.Gasolinera;

public class Coche extends Thread {

    private String marca;
    private Gasolinera gasolinera;

    public Coche(String marca, Gasolinera gasolinera) {
        this.marca = marca;
        this.gasolinera = gasolinera;
    }

    public String getMarca() {
        return marca;
    }


    @Override
    public void run() {

        gasolinera.repostar(marca);

    }
}
