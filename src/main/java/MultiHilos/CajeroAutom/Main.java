package MultiHilos.CajeroAutom;

public class Main {
    public static void main(String[] args){

        CuentaBancaria c1 = new CuentaBancaria();
        Persona p1 = new Persona("Eduardo");
        Persona p2 = new Persona("María");
        Persona p3 = new Persona("Marta");
        Persona p4 = new Persona("Luis");

        new Thread() {
            @Override
            public void run() {
                try {
                    c1.sacarDinero(p1, 60);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        }.start();

        new Thread() {
            @Override
            public void run() {

                c1.consultarSaldo(p2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    c1.ingresarDinero(p3, 80);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    c1.sacarDinero(p4, 20);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    c1.sacarDinero(p3, 20);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    c1.ingresarDinero(p1, 30);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }.start();

    }
}
