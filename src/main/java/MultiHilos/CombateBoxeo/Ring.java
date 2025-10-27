package MultiHilos.CombateBoxeo;

/*
 * La clase Ring es el recurso compartido
 */
public class Ring {

        private boolean combateIniciado = false;
        private boolean combateTerminado = false;

        public Ring() {
        }

        public synchronized void esperarIniciarCombate() throws InterruptedException{
            while(!combateIniciado){
                wait();
            }
        }

        public synchronized void empezarCombate(){
            combateIniciado = true;
            System.out.println("Empieza el combate");
            notifyAll();
        }


        public synchronized void terminarCombate(){
            combateTerminado = true;
            System.out.println("Termina el combate");
            notifyAll();
        }

        public synchronized boolean haTerminadoCombate(){
            return combateTerminado;
        }



}
