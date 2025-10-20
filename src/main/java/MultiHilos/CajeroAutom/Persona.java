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
public class Persona {
    private String nombre;


    public Persona(String nombre) {
        super();
        this.nombre = nombre;

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }




}
