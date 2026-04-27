package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazVerCliente extends JFrame {


    public InterfazVerCliente(){
        setTitle("Añadir Cliente");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);


        JPanel panel = new JPanel(new GridLayout(2, 5, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel dni = new JLabel("dni");

        JLabel nombre = new JLabel("nombre");

        JLabel apellidos = new JLabel("apellidos");

        JLabel telefono = new JLabel("telefono");
        JLabel correo = new JLabel("correo");


        JButton volver = new JButton("volver");
        JButton añadir = new JButton("añadir");




        panel.add(dni);

        panel.add(nombre);

        panel.add(apellidos);

        panel.add(telefono);

        panel.add(nombre);
        panel.add(correo);

        panel.add(volver);
        panel.add(añadir);
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
        InterfazVerCliente interfazAñadirCliente = new InterfazVerCliente();
        interfazAñadirCliente.setVisible(true);
    }
}
