package ServiciosRed.Poke;

import java.util.List;

public class Pokemon {

    // --- CAMPOS DIRECTOS (Igual que el JSON) ---
    private int id;
    private String name;
    private int height;
    private int weight;

    // --- OBJETOS ANIDADOS ---
    private Sprites sprites; // Para sacar la foto

    // --- CLASES INTERNAS (Para mapear lo de dentro) ---
    public static class Sprites {
        // La API tiene un campo "front_default" con la URL de la foto
        String front_default;
    }

    // --- GETTERS ---
    public int getId() { return id; }
    public String getName() { return name; }
    public int getHeight() { return height; }
    public int getWeight() { return weight; }

    // --- GETTER INTELIGENTE PARA LA FOTO ---
    public String getImagenUrl() {
        if (sprites != null && sprites.front_default != null) {
            return sprites.front_default;
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        s+= "ID: "+id+", ";
        s+= "Nombre: "+name+", ";
        s+= "Altura: "+height+", ";
        s+= "Peso: "+weight;
        return s;
    }
}
