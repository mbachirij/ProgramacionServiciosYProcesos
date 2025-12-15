package ServiciosRed.RickMorty;

public class Personaje {
    private int id;
    private String nombre;
    private String estado;
    private String especie;
    private String genero;
    private String origen;
    private String ubicacion;
    private int numEpisodios;
    private String urlImagen;

    public Personaje(int id, String nombre, String estado, String especie, String genero, String origen, String ubicacion, int numEpisodios, String urlImagen) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.especie = especie;
        this.genero = genero;
        this.origen = origen;
        this.ubicacion = ubicacion;
        this.numEpisodios = numEpisodios;
        this.urlImagen = urlImagen;
    }
    public int getId() { return id; }
    public String getGenero() { return genero; }
    public String getOrigen() { return origen; }
    public String getUbicacion() { return ubicacion; }
    public int getNumEpisodios() { return numEpisodios; }
    public String getUrlImagen() { return urlImagen; }
    public String getEspecie() { return especie; }
    public String getNombre() { return nombre; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setUrlImagen(String urlImagen) { this.urlImagen = urlImagen; }
    public void setNumEpisodios(int numEpisodios) { this.numEpisodios = numEpisodios; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public void setOrigen(String origen) { this.origen = origen; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setEspecie(String especie) { this.especie = especie; }
    public void setId(int id) { this.id = id; }

    public String toString(){
        String s = "";
        s+= "Id: "+id+"\n";
        s+= "Nombre: "+nombre+"\n";
        s+= "Estado: "+estado+"\n";
        s+= "Especie: "+especie+"\n";
        s+= "Género: "+genero+"\n";
        s+= "Origen: "+origen+"\n";
        s+= "Ubicación: "+ubicacion+"\n";
        s+= "Número de episodios en los que aparece: "+numEpisodios+"\n";
        s+= "URL de la imagen: "+urlImagen+"\n";
        return s;
    }
}
