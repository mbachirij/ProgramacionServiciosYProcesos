/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Multiproceso;

import java.io.IOException;

/**
 *
 * @author Vespertino
 */ 
public class ProcesoVeces {
    
    public static void main(String[] args) {
        
        if (args.length != 2) {
            System.out.println("Deben ser 2 argumentos");
            System.exit(0);
            
            String pr = args[0];
            int veces = Integer.parseInt(args[1]);
            
            try {
                
                ProcessBuilder pb = new ProcessBuilder(pr);
                for (int i = 0; i < veces; i++) {
                    Process process = pb.start();
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
    }
}
