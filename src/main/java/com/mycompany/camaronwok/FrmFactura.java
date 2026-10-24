package com.mycompany.camaronwok;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrmFactura extends JFrame {

    public FrmFactura() {
        setTitle("Camarón Wok - Factura");
        setSize(480, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(220, 220, 220));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Factura", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(30, 30, 30));
        lblTitulo.setBounds(80, 20, 320, 35);
        panel.add(lblTitulo);

        JSeparator linea = new JSeparator();
        linea.setBounds(140, 58, 200, 2);
        linea.setForeground(new Color(60, 60, 60));
        panel.add(linea);

        JLabel lblMesa = new JLabel("Mesa 2 - pedido #150 - Anderson", SwingConstants.CENTER);
        lblMesa.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblMesa.setOpaque(true);
        lblMesa.setBackground(Color.WHITE);
        lblMesa.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 255), 2));
        lblMesa.setBounds(60, 70, 360, 30);
        panel.add(lblMesa);

        String[] columnas = {"Producto", "cantidad", "valor"};
        Object[][] datos = {
            {"Dumplings de Cerdo", "1", "18.000"},
            {"Wok Camarón Especial", "2", "70.000"},
            {"Margarita de Maracuyá", "2", "44.000"},
            {"Mochi de Té Verde", "1", "14.000"}
        };

        DefaultTableModel model = new DefaultTableModel(datos, columnas);
        JTable tabla = new JTable(model);
        tabla.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        tabla.setRowHeight(30);
        tabla.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        tabla.getTableHeader().setBackground(new Color(200, 200, 200));

        JScrollPane scrollTabla = new JScrollPane(tabla);
        scrollTabla.setBounds(30, 115, 420, 150);
        panel.add(scrollTabla);

        JPanel panelTotales = new JPanel();
        panelTotales.setLayout(new GridLayout(4, 1, 2, 2));
        panelTotales.setBackground(Color.WHITE);
        panelTotales.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelTotales.setBounds(230, 280, 220, 100);

        JLabel lblSubtotal = new JLabel("Sub total: 146.000  ", SwingConstants.RIGHT);
        lblSubtotal.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));

        JLabel lblIva = new JLabel("IVA: 27.740  ", SwingConstants.RIGHT);
        lblIva.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));

        JLabel lblImpuesto = new JLabel("Imp. al consumo: 11.680  ", SwingConstants.RIGHT);
        lblImpuesto.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));

        JLabel lblTotal = new JLabel("TOTAL = 185.420  ", SwingConstants.RIGHT);
        lblTotal.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

        panelTotales.add(lblSubtotal);
        panelTotales.add(lblIva);
        panelTotales.add(lblImpuesto);
        panelTotales.add(lblTotal);
        panel.add(panelTotales);

        // Botón "Volver a Mesas pendientes" -> CONEXIÓN: Regresa al menú principal
        JButton btnVolver = new JButton("Volver a Mesas pendientes");
        btnVolver.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        btnVolver.setBackground(new Color(240, 140, 140));
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFocusPainted(false);
        btnVolver.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnVolver.setBounds(30, 285, 185, 45);
        btnVolver.addActionListener(e -> {
            new FrmInicioUsuario().setVisible(true);
            this.dispose();
        });
        panel.add(btnVolver);

        // Botón "Pago exitoso" -> CONEXIÓN: Muestra mensaje de éxito y regresa al menú
        JButton btnPagoExitoso = new JButton("Pago exitoso");
        btnPagoExitoso.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnPagoExitoso.setBackground(new Color(46, 139, 87));
        btnPagoExitoso.setForeground(Color.WHITE);
        btnPagoExitoso.setFocusPainted(false);
        btnPagoExitoso.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnPagoExitoso.setBounds(45, 345, 155, 42);
        
        btnPagoExitoso.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "¡Pago procesado con éxito!");
            new FrmInicioUsuario().setVisible(true);
            this.dispose();
        });
        panel.add(btnPagoExitoso);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmFactura().setVisible(true));
    }
}