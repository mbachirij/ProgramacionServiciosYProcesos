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
public class Process_builder2 {
    
    public static void main(String[] args){
        
        try{
            Process p = new ProcessBuilder("CMD","/C","dir").start();
            InputStream is = p.getInputStream();
            int c;
            while((c = is.read())!=-1){
                System.out.println(c);
                
            }
            is.close();
            int exitValue;
            exitValue = p.waitFor();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
