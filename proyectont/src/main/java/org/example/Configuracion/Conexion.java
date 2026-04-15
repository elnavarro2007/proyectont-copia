package org.example.Configuracion;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/tiendavideojuegos";
    private static final String USER = "root";
    private static final String PASSWD = "1234";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(URL, USER, PASSWD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
