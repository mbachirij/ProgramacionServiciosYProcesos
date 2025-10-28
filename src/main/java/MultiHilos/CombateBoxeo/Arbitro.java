package MultiHilos.CombateBoxeo;

<<<<<<< HEAD
public class Arbitro extends Thread{

    private Ring ring;
    private Boxeador b1;
    private Boxeador b2;

    public Arbitro(Ring ring, Boxeador b1, Boxeador b2){
        this.ring = ring;
        this.b1 = b1;
        this.b2 = b2;

    }

    @Override
    public void run(){
        try {
            System.out.println("Arbitro: ¡Empieza el combate!");
            ring.empezarCombate();

            // El arbitro duerme durante el combate
            while (!ring.haTerminadoCombate()) {
                Thread.sleep(500);
            }

            ring.terminarCombate();

            if (b1.getVida()<=0 && b2.getVida()<=0){
                System.out.println("han quedado Empate");
            } else if (b1.getVida()<=0){
                System.out.println("El boxeador "+b2.getNombre()+" ha ganado");
            } else {
                System.out.println("El boxeador "+b1.getNombre()+" ha ganado");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

=======
public class Arbitro {
>>>>>>> c272e62da602382d5d9488bbfd658a01b3e12941
}
