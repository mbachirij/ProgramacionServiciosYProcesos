import java.io.BufferedReader;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Practica_mohammedBachiriJabbouri {
    public static void main(String[] args){



        String direccion;

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
