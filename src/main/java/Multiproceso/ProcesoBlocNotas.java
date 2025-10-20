/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Multiproceso;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Vespertino
 */
public class ProcesoBlocNotas {
    
    public static void main(String[] args){
        
        String RUTA = "notePad.exe";
        ProcessBuilder pb = new ProcessBuilder(RUTA);
        try {
            
            Process ps = pb.start();
            
            while(ps.isAlive()){
                Date date = new Date();
                
                System.out.println(date+ "El proceso sigue vivo");
                
                if(ps.isAlive()){
                    ps.waitFor(5, TimeUnit.SECONDS);
                }
                
            }
            
            
        } catch (IOException e) {
            
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        
    }
    

