package MultiHilos.Practicando;

public class miPrimerHilo extends Thread{

    private String nombre;

    public miPrimerHilo(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void run(){

        for(int i=0;i<=5;i++){

            System.out.println(nombre+" dice hola "+i);

            try {
                Thread.sleep(1000); // el hilo descansa 1 segundo
            } catch (InterruptedException e){
                e.printStackTrace();
            }


        }


    }

}
