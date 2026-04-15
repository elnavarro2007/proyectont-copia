package org.example.ControladorDAO;

import org.example.Modelo.TicketCompra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
