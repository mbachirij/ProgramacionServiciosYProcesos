package ServiciosRed.Poke;

import java.util.List;

public class ListaPokemon {
    // La API devuelve: { "count": 1000, "results": [ ... ] }
    private List<PokemonSimple> results;

    public List<PokemonSimple> getResults() {
        return results;
    }

    // Clase auxiliar pequeña porque la lista solo trae nombre y url
    public static class PokemonSimple {
        String name;
        String url;
    }
}
