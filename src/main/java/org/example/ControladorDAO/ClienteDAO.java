package org.example.ControladorDAO;

import org.example.Modelo.Cliente;
import org.example.Modelo.TicketCompra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Configuracion.Conexion.getConnection;

public class ClienteDAO {
    // hacer un login para clientes para que puedan ver solo sus tickets

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

    public static boolean eliminarCliente(Cliente cliente) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("Delete from cliente where dni= ? ")) {

            ps.setString(1, cliente.getDni());


            int columnasAfectadas = ps.executeUpdate();
            return columnasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static ArrayList<Cliente> verCliente() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM cliente ")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();

                c.setDni(rs.getString("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setApellidos(rs.getString("apellidos"));
                c.setTelefono(rs.getString("telefono"));
                c.setCorreo(rs.getString("correo"));

                clientes.add(c);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }
}
