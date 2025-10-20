package Pistola;

public class Pistola {
    private int balas=40;

    public int getBalas() {
        return balas;
    }
    public void setBalas(int balas) {
        this.balas = balas;
    }

    //Método para disparar le paso las balasAdisparar
    public synchronized void disparar(int balasAdisparar){

        for(int i=0; i<=balasAdisparar; i++){
            System.out.println("Bala "+i+" disparada");
            if(balas==0){
                System.out.println(i-1+" balas disparadas "+balas+" balas restantes");
                try {
                    wait();
                    System.out.println("Continuando con los disparos después de recargar");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }
            balas--;
        }

        System.out.println("Tiroteo finalizado ");
    }


    //Método para recargar las balas
    public synchronized void recargar(){
        System.out.println("Pistola recargada");
        balas = balas+40;
        notify();

    }



}
