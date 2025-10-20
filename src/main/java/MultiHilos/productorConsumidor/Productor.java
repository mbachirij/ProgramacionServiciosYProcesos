/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiHilos.productorConsumidor;

/**
 *
 * @author Vespertino
 */
public class Productor extends Thread{

	private Cola cola;
	
		public Productor (Cola c) {
			cola = c;
		}
		public void run() {
			for (int i = 0;i<5;i++) {
				cola.put(i); //pone el número en la cola
				System.out.println(i+ "=>Productor produce "+ i);
				try {
					sleep(100);
				}catch(InterruptedException ex) {
					
				}
			}
		}
		
}

