package ComunicacionRed.EjercicioHilosSockets;

import java.io.Serializable;

public class Tarea implements Serializable {

    private Persona persona;
    private String fecha;
    private String descripcion;

    public Tarea(Persona persona, String fecha, String descripcion) {
        this.persona = persona;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return persona.getNombre() + " " + fecha + " " + descripcion;
    }

}
