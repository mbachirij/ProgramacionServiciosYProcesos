package MultiHilos.CombateBoxeo;

<<<<<<< HEAD
/*
 * La clase Boxeador son los hilos
 */
public class Boxeador extends Thread{

    private String nombre;
    private Ring ring;
    private Boxeador boxeador;
    private int vida = 100;

    public Boxeador(String nombre, Ring ring){
        this.nombre = nombre;
        this.ring = ring;
    }

    public String getNombre() {
        return nombre;
    }

    public void setBoxeador(Boxeador boxeador) {
        this.boxeador = boxeador;
    }

    public int getVida() {
        return vida;
    }

    public void recibirDanio(){
        int danio = (int)(Math.random()*10);
        vida -= danio;
        if(vida<0){
            vida=0;
        }
        System.out.println(danio);
    }

    @Override
    public void run(){
        try {
            ring.esperarIniciarCombate();

            while(!ring.haTerminadoCombate() && vida>0 && boxeador.getVida()>0){

                boxeador.recibirDanio();
                System.out.println(nombre+" ha recibido un golpe le quedan "+vida+" puntos de vida - A "+boxeador.getNombre()+" le quedan "+boxeador.getVida()+" puntos de vida");
                Thread.sleep(2000);
            }

        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

=======
public class Boxeador {
>>>>>>> c272e62da602382d5d9488bbfd658a01b3e12941
}
