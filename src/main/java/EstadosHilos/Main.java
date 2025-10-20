package EstadosHilos;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        HiloAuxiliar hilo = new HiloAuxiliar();
        //Para captar el estado de un hilo
        System.out.println("Hilo con el estado "+hilo.getState());
        //Ahora lo inicializo el hilo
        hilo.start();
        System.out.println("Hilo iniciado con estado "+hilo.getState());
        System.out.println("Esperando a que termine la funcion");

        hilo.join();


        System.out.println("Hilo muerto con estado; "+hilo.getState());


    }

}
