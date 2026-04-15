package org.example.ControladorDAO;

import org.example.Modelo.Tienda;
import org.example.Modelo.Videojuegos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.Configuracion.Conexion.getConnection;

public class VideojuegoDAO {

    public VideojuegoDAO() {
    }

    // Funcion para insertar los datos en la tabla, si cumple con todos los valores del objeto y del insert, se insertaran en la tabla

    public static boolean insertarVideojuego (Videojuegos videojuego){

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO videojuego (numero_serie,nombre,genero) VALUES (?,?,?)")){


            ps.setString(1, videojuego.getNumeroSerie());
            ps.setString(2 , videojuego.getNombre());
            ps.setString(3 , videojuego.getGenero());



            int columnasAfectadas = ps.executeUpdate() ;
            return columnasAfectadas >  0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Creo la clase, creo constructor y variables,


    }
}
