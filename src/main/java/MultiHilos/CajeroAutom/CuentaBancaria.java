package MultiHilos.CajeroAutom;
/*
Crear un programa que simule un cajero automático.
La familia González ( Eduardo, María, Luis, Marta) disponen de una cuenta bancaria común.
Cada persona tiene una tarjeta de crédito, de la misma cuenta.
Cada persona podrá sacar dinero, ingresar dinero y consultar el saldo.
Hasta que una persona no haya terminado de sacar dinero o ingresar, otra persona no podrá realizar ninguna acción.
La cuenta tiene un saldo inicial de 30 euros. Ejecutar las siguientes acciones de manera simultánea.

-	Eduardo saca 60 euros.
-	María consulta el saldo
-	Marta ingresa 80 euros.
-	Luis saca 20
-	Marta saca 20.
-	Eduardo ingresa 30.
*/
public class CuentaBancaria {

    private double saldo;
    private static final double SALDO_INICIAL = 30;



    public CuentaBancaria() {
        this.saldo = SALDO_INICIAL;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public synchronized void sacarDinero(Persona p, double cantidad) throws InterruptedException{

        while(cantidad>saldo){

            System.out.println(p.getNombre()+" no hay saldo suficiente");

            wait();

        }

        setSaldo(saldo - cantidad);
        System.out.println(p.getNombre()+ " saca " + cantidad + " euros");

        //Para asegurarme que todos los que estan esperando                                                                                                                 //edelolmo@iescomercio.com
        notifyAll();
    }
    public synchronized void ingresarDinero(Persona p, double cantidad) throws InterruptedException{
        if(cantidad<0){
            System.out.println(p.getNombre()+" no puede ingresar un valor negativo");
            return;
        } else {
            setSaldo(saldo + cantidad);
            System.out.println(p.getNombre()+ " ingresa " + cantidad + " euros");
        }
    }

    public synchronized void consultarSaldo(Persona p){
        System.out.println(p.getNombre()+" consulta el saldo: "+saldo+" euros");
    }

    @Override
    public String toString() {
        String s = "";
        s+= "Saldo: "+saldo;
        return s;
    }


}
