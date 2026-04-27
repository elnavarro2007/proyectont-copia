package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazEliminarCliente extends JFrame{
    public InterfazEliminarCliente(){
        setTitle("Eliminar Cliente");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);


        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel dni = new JLabel("dni");

        JTextField DNI = new JTextField();


        JButton eliminar = new JButton("eliminar");
        JButton volver = new JButton("volver");

        panel.add(dni);
        panel.add(DNI);
        panel.add(volver);
        panel.add(eliminar);
        add(panel);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazGestionClientes interfazGestionClientes = new InterfazGestionClientes();
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        InterfazEliminarCliente interfazEliminarCliente = new InterfazEliminarCliente();
        interfazEliminarCliente.setVisible(true);
    }
}
