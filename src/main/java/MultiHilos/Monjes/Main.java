package MultiHilos.Monjes;

public class Main {

    public static void main(String[] args) {

        int numMonjes = 5;
        Monasterio monasterio = new Monasterio(numMonjes);

        Monje[] monjes = new Monje[numMonjes];
        for(int i=0; i<numMonjes; i++){
            monjes[i] = new Monje(i, monasterio);
            monjes[i].start();
        }

    }

}
