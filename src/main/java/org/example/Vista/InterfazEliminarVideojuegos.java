package org.example.Vista;

import org.example.Modelo.Videojuegos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.ControladorDAO.VideojuegoDAO.eliminarVideojuego;

public class InterfazEliminarVideojuegos extends JFrame{

    public InterfazEliminarVideojuegos(){
        setTitle("eliminar videojuego");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);

        // Panel principal 3 filas, 2 columnas
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel numeroSerie = new JLabel("numero serie");
        JButton volver = new JButton("volver");
        JButton eliminar = new JButton("eliminar");



        JTextField escribirNumeroSerie = new JTextField();

        panel.add(numeroSerie);
        panel.add(escribirNumeroSerie);
        panel.add(volver);

        panel.add(eliminar);
        add(panel);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazGestionVideojuegos interfazGestionVideojuegos = new InterfazGestionVideojuegos();
                dispose();
            }
        });
        // Codigo importante para eliminar videojuegos

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numero_serie = escribirNumeroSerie.getText().trim();

                Videojuegos videojuegos = new Videojuegos(numero_serie);

                if (eliminarVideojuego(videojuegos)){
                    JOptionPane.showMessageDialog(null, "Videojuego eliminado con exito");

                }else {
                    JOptionPane.showMessageDialog(null, "No existe esa numero");

                }
            }
        });

    }

    static void main() {
        InterfazEliminarVideojuegos interfazEliminarVideojuegos = new InterfazEliminarVideojuegos();
        interfazEliminarVideojuegos.setVisible(true);
    }
}
