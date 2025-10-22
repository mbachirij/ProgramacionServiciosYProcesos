/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serviciosprocesos;

/**
 *
 * @author Vespertino
 */
public class Pizza {
    private String tipo;
    private String tamano;
    public static int totalPedidas = 0;
    public static int totalServidas = 0;
    boolean pedida = false;
    boolean servida = false;

    public Pizza(String tipo, String tamano) {
        this.tipo = tipo;
        this.tamano = tamano;
        totalPedidas++;
        servida = false;
        pedida = true;
    }
    
    public void sirve(){
        if(!servida){
            System.out.println("esa pizza ya se ha servido");
            
        } else if(servida){
            
            totalServidas++;
            servida = true;
            
        }
    }

    public static int getTotalPedidas() {
        return totalPedidas;
    }

    public static int getTotalServidas() {
        return totalServidas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {

        String s = "";
        s+= "pizza "+tipo+" "+tamano+", ";
        if(pedida){
            s+="pedida \n";
        } else if (servida){
            s+="servida \n";
        }
        return s;
    }
    
    
    
}
