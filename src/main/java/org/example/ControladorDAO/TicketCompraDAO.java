package org.example.ControladorDAO;

import org.example.Modelo.Cliente;
import org.example.Modelo.TicketCompra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Configuracion.Conexion.getConnection;

public class TicketCompraDAO {

    public static boolean insertarCompra(TicketCompra ticket){

        try(Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement("Insert into cliente_videojuego (dni_cliente,numero_serie) VALUES(?,?)")){

            ps.setString(1, ticket.getDNI());
            ps.setString(2, ticket.getNumSerie());

            int columnasAfectadas = ps.executeUpdate() ;
            return columnasAfectadas >  0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static boolean eliminarCompra(TicketCompra ticket){
        try(Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("Delete from cliente_videojuego where dni_cliente= ? and numero_serie= ?")){

            ps.setString(1, ticket.getDNI());
            ps.setString(2, ticket.getNumSerie());

            int columnasAfectadas = ps.executeUpdate() ;
            return columnasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static ArrayList<TicketCompra> verTicket() {
        ArrayList<TicketCompra> ticket = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT cv.*,v.precio FROM cliente_videojuego cv join videojuego v on v.numero_serie = cv.numero_serie ")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TicketCompra t = new TicketCompra();

                t.setDNI(rs.getString("dni_cliente"));
                t.setNumSerie(rs.getString("numero_serie"));
                t.setPrecio(rs.getString("precio"));


                ticket.add(t);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ticket;
    }
}
