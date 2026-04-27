package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGestionClientes extends JFrame {

    public InterfazGestionClientes() {

        setTitle("interfaz gestion clientes");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JButton verClientes = new JButton("ver clientes");
        JButton eliminarClientes = new JButton("eliminar Clientes");
        JButton añadirCLientes = new JButton("Añadir Clientes");
        JButton volver = new JButton("volver");


        panel.add(verClientes);
        panel.add(eliminarClientes);
        panel.add(añadirCLientes);
        panel.add(volver);



        add(panel);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazDelAdmin interfazDelAdmin = new InterfazDelAdmin();
                dispose();
            }
        });

        verClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazVerCliente interfazVerCliente = new InterfazVerCliente();
                dispose();
            }
        });
        eliminarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazEliminarCliente interfazEliminarCliente = new InterfazEliminarCliente();
                dispose();
            }
        });
        añadirCLientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazAñadirCliente interfazAñadirCliente= new InterfazAñadirCliente();
                dispose();
            }
        });


    }

    public static void main(String[] args) {
        InterfazGestionClientes clientes = new InterfazGestionClientes();
        clientes.setVisible(true);

    }
}
