package org.example.Vista;

import javax.swing.*;
import java.awt.*;

public class InterfazAñadirTienda extends JFrame{

    public InterfazAñadirTienda(){
        setTitle("añadir videojuego");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);

        // Panel principal 3 filas, 2 columnas
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel numeroSerie = new JLabel("numero serie");
        JLabel nombre = new JLabel("nombre");
        JLabel genero = new JLabel("genero");
        JLabel precio  = new JLabel("precio");
        JButton añadir = new JButton("añadir");

        JTextField escribirNumeroSerie = new JTextField();
        JTextField escribirNombre = new JTextField();
        JTextField escribirGenero = new JTextField();
        JTextField escribirPrecio = new JTextField();
    }
}
