package org.example.ControladorDAO;

import org.example.Modelo.Cliente;
import org.example.Modelo.TiendaVideojuegos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Configuracion.Conexion.getConnection;

public class TiendaVideojuegoDAO {

    public TiendaVideojuegoDAO() {
    }
    // Funcion para insertar los datos en la tabla, si cumple con todos los valores del objeto y del insert, se insertaran en la tabla
    public static boolean insertarTiendaVideojuego(TiendaVideojuegos tiendaVideojuego) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO tienda_videojuego (id_tienda,num_serie,stock) VALUES (?,?,?)")) {

            ps.setString(1, tiendaVideojuego.getId_tienda());
            ps.setString(2, tiendaVideojuego.getNum_serie());
            ps.setString(3, tiendaVideojuego.getStock());


            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean eliminarTiendaVideojuego(TiendaVideojuegos tiendaVideojuego){
        try(Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("Delete from tienda_videojuego where id_tienda = ? and num_serie= ? ")){

            ps.setString(1, tiendaVideojuego.getId_tienda());
            ps.setString(2, tiendaVideojuego.getNum_serie());


            int columnasAfectadas = ps.executeUpdate() ;
            return columnasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<TiendaVideojuegos> verStock() {
        ArrayList<TiendaVideojuegos> tiendaVideojuegos = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM tienda_videojuego ")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TiendaVideojuegos tv = new TiendaVideojuegos();

                tv.setId_tienda(rs.getString("id_tienda"));
                tv.setNum_serie(rs.getString("num_serie"));
                tv.setStock(rs.getString("stock"));


                tiendaVideojuegos.add(tv);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tiendaVideojuegos;
    }

}
