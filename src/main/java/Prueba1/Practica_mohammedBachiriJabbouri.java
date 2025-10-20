/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Vespertino
 */
public class Practica_mohammedBachiriJabbouri {
    public static void main(String[] args){
        
        
        
        
        
        try{
            Process p = new ProcessBuilder("ping", "www.google.es").start();
            
            
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            String linea = br.readLine();
                    
            
            
            int pro = p.waitFor();
            
            if(pro == 0){
                Process p1 = new ProcessBuilder("mspaint").start();
                Thread.sleep(5000);
                
                p1.destroy();
                
                
            }
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
