package org.example.Modelo;

public class TicketCompra extends Videojuegos {
        private String DNI  ;
        private String numSerie;
        

    public TicketCompra() {
    }



    public TicketCompra(String DNI, String numSerie, String precio) {
        this.DNI = DNI;
        this.numSerie = numSerie;
        this.precio = precio;
    }



    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }



    @Override
    public String toString() {
        return "TicketCompra{" +
                "DNI='" + DNI + '\'' +
                ", numSerie='" + numSerie + '\'' +
                ", precio='" + getPrecio() + '\'' +
                '}';
    }
}
