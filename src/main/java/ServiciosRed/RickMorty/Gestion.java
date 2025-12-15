package ServiciosRed.RickMorty;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {

    ArrayList<Personaje> personajes = new ArrayList<>();
    public Gestion(){}

    public void buscarPersonaje(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del Personaje: ");
        String nombre = sc.nextLine().trim().toLowerCase();

        try {

            String url = "https://rickandmortyapi.com/api/character/?name=" + nombre;



        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
