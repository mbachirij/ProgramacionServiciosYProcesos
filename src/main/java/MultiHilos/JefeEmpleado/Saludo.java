/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiHilos.JefeEmpleado;

/**
 *
 * @author Vespertino
 */
public class Saludo {
    
    private boolean haLlegadoJefe;

    public Saludo(boolean haLlegadoJefe) {
        this.haLlegadoJefe = haLlegadoJefe;
    }

    public boolean getHaLlegadoJefe() {
        return haLlegadoJefe;
    }

    public void setHaLlegadoJefe(boolean haLlegadoJefe) {
        this.haLlegadoJefe = haLlegadoJefe;
    }
    
    public synchronized void saludoEmpleado(String nombre){
               try{ 
            if(!this.getHaLlegadoJefe()){
                wait();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public synchronized void saludoJefe(String nombre){
        System.out.println(nombre +" Buenos días empleados");
        this.setHaLlegadoJefe(true);
    }

}
    


