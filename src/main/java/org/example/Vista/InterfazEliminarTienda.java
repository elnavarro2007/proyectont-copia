package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazEliminarTienda extends JFrame {
    public InterfazEliminarTienda() {
        setTitle("Eliminar Tienda");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);


        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel id = new JLabel("id");
        JLabel nombreTienda = new JLabel("nombre tienda");
        JTextField escribirID = new JTextField();
        JTextField escribirNombre = new JTextField();
        JButton volver = new JButton("volver");
        JButton eliminar = new JButton("eliminar");

        panel.add(id);
        panel.add(escribirID);
        panel.add(nombreTienda);
        panel.add(escribirNombre);
        panel.add(volver);
        panel.add(eliminar);
        add(panel);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazGestionTienda interfazGestionTienda = new InterfazGestionTienda();
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        InterfazEliminarTienda interfazEliminarTienda = new InterfazEliminarTienda();
        interfazEliminarTienda.setVisible(true);
    }
}
