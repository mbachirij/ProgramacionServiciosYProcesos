/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serviciosprocesos;

/**
 *
 * @author Vespertino
 */
public class Triangulo extends Geometria{

    public Triangulo(int ancho, int altura) {
        super(ancho, altura);
    }
    
    public double areaTriangulo(){
        double area = (getAncho()*getAltura())/2;
        return area;
    }
    
}
