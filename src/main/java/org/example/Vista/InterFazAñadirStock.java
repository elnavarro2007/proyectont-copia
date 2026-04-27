package org.example.Vista;

import org.example.ControladorDAO.TiendaVideojuegoDAO;
import org.example.Modelo.TiendaVideojuegos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterFazAñadirStock extends JFrame {
    public InterFazAñadirStock(){
        setTitle("Añadir Stock");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);


        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel idTienda = new JLabel("id_tienda");
        JLabel num_serie = new JLabel("numero de serie");
        JLabel stock = new JLabel("stock");
        JTextField escribirid = new JTextField();
        JTextField escribirserie = new JTextField();
        JTextField escribirstok = new JTextField();

        JButton añadir = new JButton("añadir");
        JButton volver = new JButton("volver");

        panel.add(idTienda);
        panel.add(escribirid);
        panel.add(num_serie);
        panel.add(escribirserie);
        panel.add(stock);
        panel.add(escribirstok);
        panel.add(volver);
        panel.add(añadir);

        add(panel);
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazGestionStock interfazGestionStock = new InterfazGestionStock();
                dispose();
            }
        });
        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = escribirid.getText().trim();
                String numero_serie = escribirserie.getText().trim();
                String stock = escribirstok.getText().trim();

                TiendaVideojuegos tiendaVideojuegos = new TiendaVideojuegos(id,numero_serie,stock);

                if (TiendaVideojuegoDAO.insertarTiendaVideojuego(tiendaVideojuegos)){
                    JOptionPane.showMessageDialog(null, "Stock añadido con exito");
                }else {
                    JOptionPane.showMessageDialog(null, "No se ha podido añadir el stock");
                }
                escribirid.setText("");
                escribirserie.setText("");
                escribirstok.setText("");


            }
        });
    }


  public   static void main(String[] args) {
        InterFazAñadirStock interFazAñadirStock = new InterFazAñadirStock();
        interFazAñadirStock.setVisible(true);
    }
}
