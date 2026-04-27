package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGestionUsuarios extends JFrame{
    public InterfazGestionUsuarios() {

        setTitle("Usuarios");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);

        // Panel principal 3 filas, 2 columnas
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JButton verUsuarios = new JButton("Ver Usuarios");
        JButton añadirUsuarios = new JButton("añadir Usuarios");
        JButton eliminarUsuarios = new JButton("eliminar usuarios");
        JButton volver = new JButton("volver");

        panel.add(verUsuarios);
        panel.add(añadirUsuarios);
        panel.add(eliminarUsuarios);
        panel.add(volver);
        add(panel);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazDelAdmin interfazDelAdmin = new InterfazDelAdmin();
                dispose();
            }
        });
        añadirUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazAñadirUsuario interfazAñadirUsuario = new InterfazAñadirUsuario();
                dispose();
            }
        });
        eliminarUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazEliminarUsuario interfazEliminarUsuario = new InterfazEliminarUsuario();
                dispose();
            }
        });
    }
}
