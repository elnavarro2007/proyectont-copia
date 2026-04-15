package org.example.Modelo;

public class Videojuegos {

    private String numeroSerie;
    private String nombre;
    private String genero;

    //Constructores


    public Videojuegos() {
    }

    public Videojuegos(String numeroSerie, String nombre, String genero) {
        this.numeroSerie = numeroSerie;
        this.nombre = nombre;
        this.genero = genero;
    }

// Getter y setters


    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // toString


    @Override
    public String toString() {
        return "Videojuegos{" +
                "numeroSerie='" + numeroSerie + '\'' +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
