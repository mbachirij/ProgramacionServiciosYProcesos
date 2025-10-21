package MultiHilos.Imprenta;

public class Oficina {

    private Impresora[] impresora = new Impresora[2];

    public Oficina(int numImpresoras) {
        impresora = new Impresora[numImpresoras];
        for (int i = 0; i < numImpresoras; i++) {
            impresora[i] = new Impresora(i+1);
        }
    }

    public synchronized Impresora pedirImpresora(Trabajador t) throws InterruptedException {

        while(true){
            for(Impresora i: impresora){
                if(!i.isOcupada()){
                    return i;
                }
            }
            wait();
        }
    }



}
