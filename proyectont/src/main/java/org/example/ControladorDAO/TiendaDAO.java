package org.example.ControladorDAO;

import org.example.Modelo.Tienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.Configuracion.Conexion.getConnection;

public class TiendaDAO {

    public TiendaDAO (){

    }
    // Funcion para insertar los datos en la tabla, si cumple con todos los valores del objeto y del insert, se insertaran en la tabla

    public static boolean insertarTienda (Tienda tienda){

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO TIENDA (nombre_tienda,telefono,stock,ubicacion) VALUES (?,?,?,?)")){


            ps.setString(1, tienda.getNombreTienda());
            ps.setString(2 , tienda.getTelefono());
            ps.setString(3, tienda.getStock());
            ps.setString(4, tienda.getUbicacion());


            int columnasAfectadas = ps.executeUpdate() ;
            return columnasAfectadas >  0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Creo la clase, creo constructor y variables,


    }

}
