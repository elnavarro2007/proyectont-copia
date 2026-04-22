package org.example.ControladorDAO;

import org.example.Modelo.Usuario;
import org.example.Modelo.Videojuegos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.Configuracion.Conexion.getConnection;

public class UsuarioDAO {

    public static boolean comprobarUserRegistro(Usuario usuario) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM cliente WHERE correo = ?")) {

            ps.setString(1, usuario.getEmail());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean compruebaUsuarioLogin(Usuario usuario) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT nombre, password FROM usuarios WHERE nombre = ? AND password = ?")) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getPassword());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean insertarUsuario(Usuario usuario) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO usuarios (nombre,password,correo) VALUES (?,?,?)")) {


            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getEmail());


            int columnasAfectadas = ps.executeUpdate();
            return columnasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Creo la clase, creo constructor y variables,


    }


}
