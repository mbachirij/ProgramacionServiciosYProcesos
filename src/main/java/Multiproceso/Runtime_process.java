/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Multiproceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Vespertino
 */
public class Runtime_process {
    
    public static void main(String[] args){
        // String RUTA = "notepad.exe"
        String RUTA = "ping www.google.es";
        
        try{
            Process ps = Runtime.getRuntime().exec(RUTA);
            System.out.println("ID del proceso"+ps.pid());
            // CAPTURAR LA INFORMACION
            BufferedReader reader = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            
            String linea;
            while((linea=reader.readLine())!=null){
                System.out.println(linea);
            }
            ps.waitFor();
            //ps.destroy;
            System.out.println("Proceso destruido");
        }catch(IOException e){
            // TODO Auto-generated catch clock
            e.printStackTrace();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
