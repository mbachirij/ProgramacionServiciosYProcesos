package MultiHilos.Carniceria;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        Carniceria c1 = new Carniceria(1);

        Cliente cli1 = new Cliente("Eduardo", c1);
        Cliente cli2 = new Cliente("Mohamed", c1);
        Cliente cli3 = new Cliente("Maria", c1);
        Cliente cli4 = new Cliente("Luis", c1);
        Cliente cli5 = new Cliente("Juan", c1);
        Cliente cli6 = new Cliente("Jose", c1);
        Cliente cli7 = new Cliente("Jorge", c1);
        Cliente cli8 = new Cliente("Juanito", c1);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(cli1);
        executor.execute(cli2);
        executor.execute(cli3);
        executor.execute(cli4);
        executor.execute(cli5);
        executor.execute(cli6);
        executor.execute(cli7);
        executor.execute(cli8);

        executor.shutdown();

    }
}
