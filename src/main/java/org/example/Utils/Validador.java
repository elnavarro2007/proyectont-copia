package org.example.Utils;

import org.example.Modelo.Usuario;

public class Validador {

    public static boolean comprobarUsuario(String usuario) {
        return usuario.matches("^[a-zA-Z0-9_]{4,12}$");
    }
}
