package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazDelAdmin extends JFrame {


    public InterfazDelAdmin() {
        setTitle("Gestion De elementos");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla

        // Panel principal 3 filas, 2 columnas
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setVisible(true);
        setResizable(false);

        JButton botonTienda = new JButton("Gestionar tienda");
        JButton botonClientes = new JButton("Gestionar Clientes");
        JButton botonVideojuegos = new JButton("Gestionar videojuegos");
        JButton botonStock = new JButton("Gestionar Stock");
        JButton botonTickets = new JButton("Ver Tickets");


        // acciones de los botones

        botonTienda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazGestionTienda interfazGestionTienda = new InterfazGestionTienda();
                interfazGestionTienda.setVisible(true);
                dispose();
            }
        });

        botonClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazGestionClientes interfazGestionClientes = new InterfazGestionClientes();
                interfazGestionClientes.setVisible(true);
                dispose();
            }
        });
        botonVideojuegos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazGestionVideojuegos interfazGestionVideojuegos = new InterfazGestionVideojuegos();
                interfazGestionVideojuegos.setVisible(true);
                dispose();
            }
        });

        botonStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazGestionStock interfazGestionStock = new InterfazGestionStock();
                interfazGestionStock.setVisible(true);
                dispose();
            }
        });

        botonTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazGestionTickets interfazGestionTickets = new InterfazGestionTickets();
                interfazGestionTickets.setVisible(true);
                dispose();
            }
        });


        panel.add(botonTienda);
        panel.add(botonClientes);
        panel.add(botonVideojuegos);
        panel.add(botonStock);
        panel.add(botonTickets);
        add(panel);
    }

    public static void main(String[] args) {
        new InterfazDelAdmin().setVisible(true);
    }
}
