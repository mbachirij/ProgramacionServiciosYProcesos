package MultiHilos.CombateBoxeo;

public class Main {

    public static void main(String[] args){

        Ring ring = new Ring();

        Boxeador b1 = new Boxeador("Eduardo", ring);
        Boxeador b2 = new Boxeador("Mohamed", ring);

        b1.setBoxeador(b2);
        b2.setBoxeador(b1);

        Arbitro arbitro = new Arbitro(ring, b1, b2);

        b1.start();
        b2.start();
        arbitro.start();
    }

}
