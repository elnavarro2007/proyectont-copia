package org.example.Vista;

import org.example.ControladorDAO.VideojuegoDAO;
import org.example.Modelo.TiendaVideojuegos;
import org.example.Modelo.Videojuegos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.ControladorDAO.TiendaVideojuegoDAO.eliminarTiendaVideojuego;

public class InterfazAñadirVideojuegos extends JFrame{

    public InterfazAñadirVideojuegos(){

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
        JButton volver = new JButton("volver");
        JButton añadir = new JButton("añadir");
        JTextField escribirNumeroSerie = new JTextField();
        JTextField escribirNombre = new JTextField();
        JTextField escribirGenero = new JTextField();
        JTextField escribirPrecio = new JTextField();

        panel.add(numeroSerie);
        panel.add(escribirNumeroSerie);
        panel.add(nombre);
        panel.add(escribirNombre);
        panel.add(genero);
        panel.add(escribirGenero);
        panel.add(precio);
        panel.add(escribirPrecio);
        panel.add(volver);
        panel.add(añadir);
        add(panel);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazGestionVideojuegos interfazGestionVideojuegos = new InterfazGestionVideojuegos();
                dispose();
            }
        });
        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroSerie = escribirNumeroSerie.getText().trim();
                String nombre = escribirNombre.getText().trim();
                String genero = escribirGenero.getText().trim();
                String precio = escribirPrecio.getText().trim();


                Videojuegos videojuegos = new Videojuegos(numeroSerie,nombre,genero,precio);

                if (VideojuegoDAO.insertarVideojuego(videojuegos)){
                    JOptionPane.showMessageDialog(null, "Videojuego Añadido con exito");


                }else {
                    JOptionPane.showMessageDialog(null, "no se ha podido añadir");

                }
                escribirNumeroSerie.setText("");
                escribirNombre.setText("");
                escribirGenero.setText("");
                escribirPrecio.setText("");

            }
        });


    }

    public static void main(String[] args) {
        InterfazAñadirVideojuegos interfazAñadirVideojuegos = new InterfazAñadirVideojuegos();
        interfazAñadirVideojuegos.setVisible(true);
    }
}
