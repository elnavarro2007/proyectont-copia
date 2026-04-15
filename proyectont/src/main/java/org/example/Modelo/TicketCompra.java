package org.example.Modelo;

public class TicketCompra {
        private String DNI  ;
        private String numSerie;

    public TicketCompra() {
    }

    public TicketCompra(String DNI, String numSerie) {
        this.DNI = DNI;
        this.numSerie = numSerie;
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
                '}';
    }
}
