package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGestionTienda extends JFrame {


    public InterfazGestionTienda(){
        setTitle("interfaz gestion Tienda");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JButton verTiendas = new JButton("datos de las tiendas");
        JButton añadirTiendas = new JButton("añadir tiendas");
        JButton eliminarTiendas = new JButton("eliminar tiendas");
        JButton volver = new JButton("volver");



        panel.add(verTiendas);
        panel.add(añadirTiendas);
        panel.add(eliminarTiendas);
        panel.add(volver);


        add(panel);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazDelAdmin interfazDelAdmin = new InterfazDelAdmin();
                dispose();
            }
        });
        añadirTiendas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazAñadirTienda interfazAñadirTienda = new InterfazAñadirTienda();
                dispose();
            }
        });
        eliminarTiendas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazEliminarTienda interfazEliminarTienda = new InterfazEliminarTienda();
                dispose();
            }
        });


    }

    public static void main(String[] args) {
        InterfazGestionTienda gestionTienda = new InterfazGestionTienda();
        gestionTienda.setVisible(true);

    }

}
