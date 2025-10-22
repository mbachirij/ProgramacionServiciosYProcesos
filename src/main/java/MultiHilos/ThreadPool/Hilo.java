package ThreadPool;

public class Hilo implements Runnable {

    private int id;

    public Hilo(int id) {
        super();
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Hilo "+ this.id +" coge el pool "+ Thread.currentThread().getThreadGroup().getName());

        try {
            Thread.sleep((int) (Math.random() * 200 * 100));
            System.out.println("Hilo " + this.id + " deja el pool " + Thread.currentThread().getThreadGroup().getName());
        }catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
