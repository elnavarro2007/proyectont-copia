package org.example.Modelo;

public class Tienda {

   private String nombreTienda;
   private String telefono;
   private String ubicacion;
   private String correo;



    //Constructores


    public Tienda() {
    }

    public Tienda(String nombreTienda, String telefono, String ubicacion, String correo) {
        this.nombreTienda = nombreTienda;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.correo = correo;
    }

// Getter and setter

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    //Tostring


    @Override
    public String toString() {
        return "Tienda{" +
                "nombreTienda='" + nombreTienda + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
