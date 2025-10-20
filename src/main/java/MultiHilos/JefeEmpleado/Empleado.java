/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiHilos.JefeEmpleado;

/**
 *
 * @author Vespertino
 */
public class Empleado {
    
    String nombre;
    boolean esJefe;
    Saludo saludo;

    public Empleado(String nombre, boolean esJefe, Saludo saludo) {
        this.nombre = nombre;
        this.esJefe = esJefe;
        this.saludo = saludo;
    }
    
   
    public void run(){
        System.out.println(nombre+"acaba de llegar");
        if(esJefe){
            saludo.saludoJefe(nombre);
        } else {
            saludo.saludoEmpleado(nombre);
        }
    }
    
    
}
