package org.example.ControladorDAO;

import org.example.Modelo.TicketCompra;
import org.example.Modelo.Tienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Configuracion.Conexion.getConnection;

public class TiendaDAO {

    public TiendaDAO() {

    }
    // Funcion para insertar los datos en la tabla, si cumple con todos los valores del objeto y del insert, se insertaran en la tabla

    public static boolean insertarTienda(Tienda tienda) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO TIENDA (nombre_tienda,telefono,ubicacion,correo) VALUES (?,?,?,?)")) {


            ps.setString(1, tienda.getNombreTienda());
            ps.setString(2, tienda.getTelefono());
            ps.setString(3, tienda.getUbicacion());
            ps.setString(4, tienda.getCorreo());



            int columnasAfectadas = ps.executeUpdate();
            return columnasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static boolean eliminarTienda(Tienda tienda){
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("Delete from tienda where nombre_tienda=?")) {

            ps.setString(1, tienda.getNombreTienda());


            int columnasAfectadas = ps.executeUpdate();
            return columnasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Tienda> verTienda() {
        ArrayList<Tienda> tiendas = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * from tienda ")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tienda t = new Tienda();

                t.setNombreTienda(rs.getString("nombre_tienda"));
                t.setTelefono(rs.getString("telefono"));
                t.setUbicacion(rs.getString("ubicacion"));


                tiendas.add(t);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tiendas;
    }

    public static ArrayList<Tienda> iniciarCorreoTienda() {
        ArrayList<Tienda> tiendas = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT correo,contrasenia from tienda where correo = ?    ")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tienda t = new Tienda();

                t.setCorreo(rs.getString("Correo"));


                tiendas.add(t);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tiendas;
    }

    public static ArrayList<Tienda> iniciarPasswdTienda() {
        ArrayList<Tienda> tiendas = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT contrasenia from tienda where contrasenia = ?    ")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tienda t = new Tienda();

                t.setCorreo(rs.getString("contrasenia"));


                tiendas.add(t);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tiendas;
    }

}


