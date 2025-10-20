package BarHilosDorados;

//En el bar “Los Hilos Dorados” hay 3 camareros.
//Cada uno puede atender a un cliente a la vez.
//El bar tiene un aforo total de 40 personas, y todos quieren pedir una bebida.
//Cuando el bar abre, los clientes llegan y son atendidos por los camareros disponibles.
//Cada servicio tarda entre 1 y 4 segundos, y cuando terminan,
// el camarero queda libre para atender al siguiente cliente.

import java.util.concurrent.Semaphore;

public class Cliente implements Runnable{

    private Semaphore aforo;
    private Semaphore camarero;
    private int idCliente;

    public Cliente(Semaphore aforo, Semaphore camarero, int idCliente) {
        this.aforo = aforo;
        this.camarero = camarero;
        this.idCliente = idCliente;
    }

    @Override
    public void run(){
        try{
        System.out.println("Cliente " + idCliente + " intentando entrar al bar...");

        aforo.acquire();
        System.out.println("Cliente " + idCliente + " entró al bar.");


        System.out.println("Cliente " + idCliente + " esperando por un camarero...");
        camarero.acquire();
        System.out.println("Cliente " + idCliente + " siendo atendido por un camarero.");


        int tiempoServicio = (int) Math.random()*400+1;
        System.out.println("Cliente " + idCliente + " siendo atendido por " + tiempoServicio + " segundos.");
        Thread.sleep(tiempoServicio * 1000);


        camarero.release();
        System.out.println("Cliente " + idCliente + " ha terminado y salió del bar.");


        aforo.release();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    }


}
