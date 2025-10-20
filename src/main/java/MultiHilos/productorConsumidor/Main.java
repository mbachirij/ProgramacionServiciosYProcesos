/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiHilos.productorConsumidor;

/**
 *
 * @author Vespertino
 */
public class Main {

	public static void main(String[] args) {
		
		Cola cola = new Cola();
		Productor p = new Productor (cola);
		p.start();
		Consumidor c = new Consumidor (cola);
		c.start();

	}

}

