/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MultiHilos.productorConsumidor;

/**
 *
 * @author Vespertino
 */
public class Cola {
	int numero;
	private boolean disponible = false;
	
	public int get() {
		if(disponible) {
			disponible = false;
			return numero;
		}
		return -1;
	}
	public void put (int valor) {
		numero = valor;
		disponible = true;
	}

}

