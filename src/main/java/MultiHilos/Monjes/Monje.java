package MultiHilos.Monjes;

public class Monje extends Thread{

    private int id;
    private Monasterio monasterio;

    public Monje(int id, Monasterio monasterio){
        this.id = id;
        this.monasterio = monasterio;
    }

    private void rezar() throws InterruptedException{
        System.out.println("El monje "+id+" reza");
        Thread.sleep(1500);
        System.out.println("El monje "+id+" ha terminado de rezar.");
    }

    private void comer() throws InterruptedException{
        System.out.println("El monje "+id+" come");
        Thread.sleep(1500);
        System.out.println("El monje "+id+" ha terminado de comer.");
    }

    @Override
    public void run(){

        try{
            while(true){
                rezar();

                monasterio.intentaComer(id);
                comer();
                monasterio.soltarTenedor(id);


                Thread.sleep(1500);

            }
        } catch (InterruptedException ex) {
            System.out.println("El monje "+id+" ha sido interrumpido.");
        }

    }

}
