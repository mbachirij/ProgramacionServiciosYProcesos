/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiHilos.hilosRecursoCompartido;

/**
 *
 * @author Vespertino
 */
public class hilosR {
    public static void main(String[] args){
        
        int[] numeros = new int[4];
        
        for(int i=0; i<4; i++){
            Thread hilo = new recursoCompartido(numeros, i);
            hilo.start();
        }
    }
}
