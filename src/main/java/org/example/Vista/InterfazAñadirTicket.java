package org.example.Vista;

import org.example.ControladorDAO.TicketCompraDAO;
import org.example.Modelo.TicketCompra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazAñadirTicket extends JFrame {
    public InterfazAñadirTicket() {
        setTitle("Añadir Ticket");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setVisible(true);
        setResizable(false);


        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel DNI = new JLabel("dni Cliente");
        JLabel num_serie = new JLabel("numero de serie");
        JLabel precio = new JLabel("precio");
        JTextField escribirDNi = new JTextField();
        JTextField escribirSerie = new JTextField();
        JTextField escribirPrecio = new JTextField();

        JButton añadir = new JButton("añadir");
        JButton volver = new JButton("volver");

        panel.add(DNI);
        panel.add(escribirDNi);
        panel.add(num_serie);
        panel.add(escribirSerie);
        panel.add(precio);
        panel.add(escribirPrecio);
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
                String dni = escribirDNi.getText().trim();
                String numero_serie = escribirSerie.getText().trim();
                String ticket = escribirPrecio.getText().trim();

                TicketCompra ticketCompra = new TicketCompra(dni,numero_serie,ticket);

                if (TicketCompraDAO.insertarCompra(ticketCompra)){
                    JOptionPane.showMessageDialog(null, "Compra realizada con exito");
                }else {
                    JOptionPane.showMessageDialog(null,"Fallo al comprar");
                }
                escribirDNi.setText("");
                escribirSerie.setText("");
                escribirPrecio.setText("");

            }
        });



    }
}
