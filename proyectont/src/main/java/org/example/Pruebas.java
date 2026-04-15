package org.example;

import org.example.Modelo.Cliente;
import org.example.Modelo.TicketCompra;
import org.example.Modelo.Tienda;
import org.example.Modelo.Videojuegos;
import org.example.Vista.InterfazLogin;

import static org.example.ControladorDAO.ClienteDAO.insertarCliente;
import static org.example.ControladorDAO.TicketCompraDAO.eliminarCompra;
import static org.example.ControladorDAO.TiendaDAO.insertarTienda;
import static org.example.ControladorDAO.VideojuegoDAO.insertarVideojuego;
import static org.example.ControladorDAO.TicketCompraDAO.insertarCompra;

public class Pruebas {
    public static void main(String[] args) {


      //  Cliente cliente = new Cliente("12345679A", "Yo", "Yo", "y0o@h.com", "21333333");
      //  Tienda tienda = new Tienda("Gama", "123456780", "300", "calle clementes 24");
      //  Videojuegos videojuego = new Videojuegos("123456781", "Persona 4", "RPG");
        TicketCompra ticket = new TicketCompra("12345679A","123456781");
       // if (insertarCliente(cliente)) {
       //     System.out.println("insertado");
       // } else {
       //     System.out.println("No insertado");
       // }
       // if (insertarTienda(tienda)) {
       //     System.out.println("insertado");
       // } else {
       //     System.out.println("No insertado");
       // }
       // if (insertarVideojuego(videojuego)) {
       //     System.out.println("insertado");
       // } else {
       //     System.out.println("No insertado");
       // }
       // if (insertarCompra(ticket)){
       //     System.out.println("Insertado");
       // }else {
       //     System.out.println("no insertado");
       // }

        if (eliminarCompra(ticket)){
            System.out.println("Eliminado");
        }else {
            System.out.println("no eliminado");
        }


    }
}
