package org.example.Vista;

import javax.swing.*;
import java.awt.*;

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
        JTextField id = new JTextField();
        JTextField serie = new JTextField();
        JTextField stok = new JTextField();

        JButton añadir = new JButton("añadir");
        JButton volver = new JButton("volver");

        panel.add(idTienda);
        panel.add(id);
        panel.add(num_serie);
        panel.add(serie);
        panel.add(stock);
        panel.add(stok);
        panel.add(volver);
        panel.add(añadir);

        add(panel);
    }

    static void main() {
        InterFazAñadirStock interFazAñadirStock = new InterFazAñadirStock();
        interFazAñadirStock.setVisible(true);
    }
}
