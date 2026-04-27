package org.example.Vista;

import org.example.Modelo.TiendaVideojuegos;
import org.example.Modelo.Videojuegos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.ControladorDAO.TiendaVideojuegoDAO.eliminarTiendaVideojuego;
import static org.example.ControladorDAO.VideojuegoDAO.eliminarVideojuego;

public class InterfazEliminarStock extends JFrame{

    public InterfazEliminarStock(){
        setTitle("eliminar stock");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);

        // Panel principal 3 filas, 2 columnas
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel idTienda = new JLabel("id tienda");
        JLabel numeroSerie = new JLabel("numero serie");
        JButton volver = new JButton("volver");
        JButton eliminar = new JButton("eliminar");


        JTextField escribirId = new JTextField();
        JTextField escribirNumeroSerie = new JTextField();

        panel.add(idTienda);
        panel.add(escribirId);
        panel.add(numeroSerie);
        panel.add(escribirNumeroSerie);
        panel.add(volver);

        panel.add(eliminar);
        add(panel);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazGestionStock interfazGestionVideojuegos = new InterfazGestionStock();
                dispose();
            }
        });
        // Codigo importante para eliminar videojuegos

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = escribirId.getText().trim();
                String numero_serie = escribirNumeroSerie.getText().trim();

                TiendaVideojuegos tiendaVideojuegos = new TiendaVideojuegos(id,numero_serie);

                if (eliminarTiendaVideojuego(tiendaVideojuegos)){
                    JOptionPane.showMessageDialog(null, "Stock eliminado con exito");

                }else {
                    JOptionPane.showMessageDialog(null, "No existe esa numero");

                }
            }
        });
    }

    public static void main(String [] args) {
        InterfazEliminarStock interfazEliminarStock = new InterfazEliminarStock();
        interfazEliminarStock.setVisible(true);
    }

}
