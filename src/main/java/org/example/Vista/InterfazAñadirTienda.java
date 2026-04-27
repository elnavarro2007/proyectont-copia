package org.example.Vista;

import org.example.ControladorDAO.TiendaDAO;
import org.example.Modelo.Tienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazAñadirTienda extends JFrame{

    public InterfazAñadirTienda(){
        setTitle("añadir tienda");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);

        // Panel principal 3 filas, 2 columnas
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel nombreTienda = new JLabel("nombre tienda");
        JLabel telefono = new JLabel("telefono");
        JLabel ubicacion  = new JLabel("ubicacion");
        JLabel correo = new JLabel("corrreo");
        JButton añadir  = new JButton("añadir");
        JButton volver = new JButton("volver");

        JTextField escribirNombreTienda = new JTextField();
        JTextField escribirTelefono = new JTextField();
        JTextField escribirUbicacion= new JTextField();
        JTextField escribirCorreo = new JTextField();

        panel.add(nombreTienda);
        panel.add(escribirNombreTienda);
        panel.add(telefono);
        panel.add(escribirTelefono);
        panel.add(ubicacion);
        panel.add(escribirUbicacion);
        panel.add(correo);
        panel.add(escribirCorreo);
        panel.add(volver);
        panel.add(añadir);
        add(panel);

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazGestionTienda interfazGestionClientes = new InterfazGestionTienda();
                dispose();
            }
        });
        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = escribirNombreTienda.getText().trim();
                String telefono = escribirTelefono.getText().trim();
                String ubicacion = escribirUbicacion.getText().trim();
                String correo = escribirCorreo.getText().trim();

                Tienda tienda = new Tienda(nombre,telefono,ubicacion,correo);
                if (TiendaDAO.insertarTienda(tienda)){
                    JOptionPane.showMessageDialog(null,"Tienda añadida con exito");
                }else {
                    JOptionPane.showMessageDialog(null,"Error al añadir la tienda");
                }
                escribirNombreTienda.setText("");
                escribirUbicacion.setText("");
                escribirCorreo.setText("");
                escribirTelefono.setText("");
            }
        });

    }

    public static void main(String[] args) {
        InterfazAñadirTienda interfazAñadirTienda = new InterfazAñadirTienda();
        interfazAñadirTienda.setVisible(true);
    }
}
