package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazEliminarUsuario extends JFrame {

    public InterfazEliminarUsuario() {
        setTitle("Eliminar Usuario");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);


        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel correo = new JLabel("correo");
        JTextField escribirCorero = new JTextField();
        JButton volver = new JButton("volver");
        JButton eliminar = new JButton("eliminar");

        panel.add(correo);
        panel.add(escribirCorero);
        panel.add(volver);
        panel.add(eliminar);
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

