package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGestionTickets extends JFrame {

    public InterfazGestionTickets() {
        setTitle("Gestion De Tickets");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);

        // Panel principal 3 filas, 2 columnas
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setVisible(true);
        setResizable(false);

        JButton verTickets = new JButton("Ver Tickets");
        JButton añadirTickets = new JButton(" Añadir Tickets");
        JButton volver = new JButton("volver");

        panel.add(verTickets);
        panel.add(añadirTickets);
        panel.add(volver);

        add(panel);


        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazDelAdmin interfazDelAdmin = new InterfazDelAdmin();
                dispose();
            }
        });
        añadirTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazAñadirTicket interfazAñadirTicket = new InterfazAñadirTicket();
                dispose();
            }
        });
    }

    static void main() {
        InterfazGestionClientes interfazGestionClientes = new InterfazGestionClientes();
        interfazGestionClientes.setVisible(true);
    }
}
