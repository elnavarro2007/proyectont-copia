package org.example.Modelo;

public class TiendaVideojuegos {
    private String id_tienda;
    private String num_serie;
    private String Stock;

    public TiendaVideojuegos() {
    }

    public TiendaVideojuegos(String id_tienda, String num_serie, String stock) {
        this.id_tienda = id_tienda;
        this.num_serie = num_serie;
        Stock = stock;
    }

    public TiendaVideojuegos(String id_tienda, String num_serie) {
        this.id_tienda = id_tienda;
        this.num_serie = num_serie;
    }

    public String getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(String id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    @Override
    public String toString() {
        return "TiendaVideojuegos{" +
                "id_tienda='" + id_tienda + '\'' +
                ", num_serie='" + num_serie + '\'' +
                ", Stock='" + Stock + '\'' +
                '}';
    }
}
