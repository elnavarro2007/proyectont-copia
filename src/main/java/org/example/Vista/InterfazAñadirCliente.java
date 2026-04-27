package org.example.Vista;

import org.example.ControladorDAO.ClienteDAO;
import org.example.Modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazAñadirCliente extends JFrame{
    public InterfazAñadirCliente() {


        setTitle("Añadir Cliente");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);


        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel DNI = new JLabel("DNI");
        JLabel nombre = new JLabel("nombre");
        JLabel apellidos = new JLabel("apellidos");
        JLabel telefono = new JLabel("telefono");
        JLabel correo = new JLabel("correo");

        JTextField escribirDNi = new JTextField();
        JTextField escribirNombre = new JTextField();
        JTextField escribirAPellidos = new JTextField();
        JTextField escribirTelefono = new JTextField();
        JTextField escribirCorreo = new JTextField();

        JButton añadir = new JButton("añadir");
        JButton volver = new JButton("volver");

        panel.add(DNI);
        panel.add(escribirDNi);
        panel.add(nombre);
        panel.add(escribirNombre);
        panel.add(apellidos);
        panel.add(escribirAPellidos);
        panel.add(telefono);
        panel.add(escribirTelefono);
        panel.add(correo);
        panel.add(escribirCorreo);
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
        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = escribirDNi.getText().trim();
                String nombre =  escribirNombre.getText().trim();
                String apellidos = escribirAPellidos.getText();
                String telefono = escribirTelefono.getText().trim();
                String correo = escribirCorreo.getText().trim();

                Cliente cliente = new Cliente(dni,nombre,apellidos,telefono,correo);

                if (ClienteDAO.insertarCliente(cliente)){
                    JOptionPane.showMessageDialog(null,"Usuario añadido con exito");
                }else {
                    JOptionPane.showMessageDialog(null," No se ha podido añadir el cliente");
                }
                escribirDNi.setText("");
                escribirNombre.setText("");
                escribirAPellidos.setText("");
                escribirCorreo.setText("");
                escribirTelefono.setText("");


            }
        });
    }
}
