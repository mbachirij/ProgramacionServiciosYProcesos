/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.serviciosprocesos;

import java.util.Scanner;

/**
 * Crea un programa que adivine un número por teclado del 1 al 10.
 * Si es correcto imprimirá "ADIVINADO", en caso contrario "PRUEBA OTRA VEZ".
 * @author Vespertino
 */
public class NumAleatorio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numAleatorio = (int)(Math.random()*10);
        
        int num;

        
        do{
            System.out.print("Adivina el número: ");
            num = sc.nextInt(); 
            
            if(num<0||num>10){
                System.out.println("El número tiene que estar entre 1 y 10");
            }
        } while(num!=numAleatorio);
        
        System.out.println("Adivinado!!! El número es: "+numAleatorio);
    }
}
