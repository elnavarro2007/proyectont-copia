package org.example.ControladorDAO;

import org.example.Modelo.Tienda;
import org.example.Modelo.TiendaVideojuegos;
import org.example.Modelo.Videojuegos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Configuracion.Conexion.getConnection;

public class VideojuegoDAO {

    public VideojuegoDAO() {
    }

    // Funcion para insertar los datos en la tabla, si cumple con todos los valores del objeto y del insert, se insertaran en la tabla

    public static boolean insertarVideojuego (Videojuegos videojuego){

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO videojuego (numero_serie,nombre,genero,precio) VALUES (?,?,?,?)")){


            ps.setString(1, videojuego.getNumeroSerie());
            ps.setString(2 , videojuego.getNombre());
            ps.setString(3 , videojuego.getGenero());
            ps.setString(4 , videojuego.getPrecio());


            int columnasAfectadas = ps.executeUpdate() ;
            return columnasAfectadas >  0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Creo la clase, creo constructor y variables,


    }
    public static boolean eliminarVideojuego(Videojuegos videojuego){
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("Delete from videojuego where numero_serie=?")) {

            ps.setString(1, videojuego.getNumeroSerie());


            int columnasAfectadas = ps.executeUpdate();
            return columnasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Videojuegos> verVideojuegos() {
        ArrayList<Videojuegos> videojuegos = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM videojuego ")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Videojuegos v = new Videojuegos();

                v.setNumeroSerie(rs.getString("numero_serie"));
                v.setNombre(rs.getString("nombre"));
                v.setGenero(rs.getString("genero"));
                v.setPrecio(rs.getString("precio"));


                videojuegos.add(v);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return videojuegos;
    }
}
