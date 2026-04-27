package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazAñadirUsuario extends JFrame {

    public InterfazAñadirUsuario() {

        setTitle("añadir videojuego");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);

        // Panel principal 3 filas, 2 columnas
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel correo = new JLabel("correo");
        JLabel contraseña = new JLabel("contraseña");
        JButton volver = new JButton("volver");
        JButton añadir = new JButton("añadir");
        JTextField escribirCorreo = new JTextField();
        JPasswordField escribirContraseña = new JPasswordField();

        panel.add(correo);
        panel.add(escribirCorreo);
        panel.add(contraseña);
        panel.add(escribirContraseña);
        panel.add(volver);
        panel.add(añadir);
        add(panel);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazGestionUsuarios interfazGestionUsuarios = new InterfazGestionUsuarios();
                dispose();
            }
        });

    }
}
