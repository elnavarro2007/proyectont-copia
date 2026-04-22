package org.example.Vista;

import javax.swing.*;
import java.awt.*;

public class InterfazDelCliente extends JFrame {

    public InterfazDelCliente(){

        setTitle("interfaz Cliente");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla

        // Panel principal 3 filas, 2 columnas
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setVisible(true);
        setResizable(false);

        JButton botonTienda = new JButton("Ver Tickets");
        JButton botonGestionUsuario = new JButton("Gestionar usuario");



        panel.add(botonTienda);
        panel.add(botonGestionUsuario);

        add(panel);


    }

    public static void main(String[] args) {
        InterfazDelCliente interf = new InterfazDelCliente();
        interf.setVisible(true);
    }
}
