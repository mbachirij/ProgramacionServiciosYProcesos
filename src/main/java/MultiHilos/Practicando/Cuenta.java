package MultiHilos.Practicando;

public class Cuenta {
    private int saldo = 100;

    public synchronized void retirarDinero(String nombre, int cantidad){

        if(cantidad<=saldo){

            System.out.println(nombre+" va a retirar "+cantidad+" euros");
            try{
                Thread.sleep(500); // simula la operación
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            saldo -= cantidad;
            System.out.println(nombre+" ha retirado "+cantidad+" euros. Saldo restante: "+saldo);
        } else {
            System.out.println(nombre+" no puede retirar. Saldo insuficiente");
        }


    }


}
