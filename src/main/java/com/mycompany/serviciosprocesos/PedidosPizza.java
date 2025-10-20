/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serviciosprocesos;

/**
 *
 * @author Vespertino
 */
public class PedidosPizza {
    public static void main(String[] args){
        
        Pizza p1 = new Pizza("margarita", "madiana");
        Pizza p2 = new Pizza("funghi", "familiar");
        p2.sirve();
        Pizza p3 = new Pizza("cuatro quesos", "mediana");
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        
        p2.sirve();
        
        System.out.println("pedidas: "+ Pizza.getTotalPedidas());
        System.out.println("servidas: "+Pizza.getTotalServidas());
        
    }
}
