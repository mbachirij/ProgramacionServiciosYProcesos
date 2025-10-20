/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiHilos.hilosRecursoCompartido;

import java.util.Scanner;

/**
 *
 * @author Vespertino
 */
public class recursoCompartido extends Thread {
    
    int[] numeros; 
    int posicion;
    Scanner sc = new Scanner(System.in);

    public recursoCompartido(int[] numeros, int posicion) {
        this.numeros = numeros;
        this.posicion = posicion;
    }
    
    @Override
    public void run(){
        
        System.out.println("Introduce un número: ");
        int num = sc.nextInt();
        
        numeros[posicion] = num;
        System.out.println("se ha guardado el número"+num);
        
        if(posicion == numeros.length-1){
            System.out.println("numeros del array ");
            for(int num1: numeros){
                System.out.println(num1);
            }
            System.out.println();
        }
        
    }
 
}
