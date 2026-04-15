package org.example.ControladorDAO;

import org.example.Modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.Configuracion.Conexion.getConnection;

public class ClienteDAO {

    public ClienteDAO() {

    }
    // Funcion para insertar los datos en la tabla, si cumple con todos los valores del objeto y del insert, se insertaran en la tabla
    public static boolean insertarCliente(Cliente cliente) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO cliente (dni,nombre,apellidos,telefono,correo) VALUES (?,?,?,?,?)")) {

            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getCorreo());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
