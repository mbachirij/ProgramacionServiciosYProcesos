/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process_builder;

import java.io.InputStream;

/**
 *
 * @author Vespertino
 */
public class Process_builder3 {
        public static void main(String[] args){
        
            String[] comando = {"notepad.exe"};
        try{
            Process ps = new ProcessBuilder(comando).start();
            System.out.println("Lanzado proceso bloc de notas. Esperando a que lo cierres");
            System.out.println(ps.isAlive());
            ps.waitFor();
            System.out.println("Proceso finalizado");
            System.out.println(ps.isAlive());
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
