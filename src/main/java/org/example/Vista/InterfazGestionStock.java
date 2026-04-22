package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGestionStock extends JFrame {

    public InterfazGestionStock(){
        setTitle("Stock");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);

        // Panel principal 3 filas, 2 columnas
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JButton verStock = new JButton("datos del stock");
        JButton añadirStock = new JButton("añadir stock");
        JButton eliminarStock = new JButton("eliminar stock");
        JButton volver = new JButton("volver");

        panel.add(verStock);
        panel.add(añadirStock);
        panel.add(eliminarStock);
        panel.add(volver);
        add(panel);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazDelAdmin interfazDelAdmin = new InterfazDelAdmin();
                dispose();
            }
        });


    }

    static void main() {
        InterfazGestionStock interfazGestionStock = new InterfazGestionStock();
        interfazGestionStock.setVisible(true);
    }
}
