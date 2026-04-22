package org.example.Vista;

import org.example.Modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.ControladorDAO.UsuarioDAO.compruebaUsuarioLogin;

public class InterfazLogin extends JFrame {

    public InterfazLogin() {
        // Configuración de la ventana
        setTitle("Inicio de Sesión");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setResizable(false);

        // Panel principal 3 filas, 2 columnas
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Componentes
        JLabel userLabel = new JLabel("Usuario :");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField(); // Oculta los caracteres

        JButton loginButton = new JButton("Entrar");
        JLabel imagen = new JLabel("");

        // Las acciones que hara cuando clickee el boton
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuarioNombre = userField.getText().trim();
                String password = new String(passField.getPassword()).trim();

                // Validación simple de ejemplo
                /*
                if (usuario.equals(TiendaDAO.iniciarCorreoTienda()) && password.equals(TiendaDAO.iniciarPasswdTienda())) {
                    JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema!");
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                }


                 */

                Usuario usuario = new Usuario(usuarioNombre, password);

                if (compruebaUsuarioLogin(usuario)) {
                    JOptionPane.showMessageDialog(null, "Usuario Correcto");
                    dispose();

                    if(usuarioNombre.equals("admin")){
                        InterfazDelAdmin gestion = new InterfazDelAdmin();
                        gestion.setVisible(true);
                    }else {
                        InterfazDelCliente cliente = new InterfazDelCliente();
                        cliente.setVisible(true);
                    }




                }else {
                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecto");
                }
            }
        });

        // Agregar elementos al panel
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);
    }

    public static void main(String[] args) {
        // Punto de entrada del programa

            new InterfazLogin().setVisible(true);

    }
}
