package com.mycompany.camaronwok;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrmResumenPedido extends JFrame {

    public FrmResumenPedido() {
        setTitle("Camarón Wok - Tomar Pedido (Resumen)");
        setSize(480, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(220, 220, 220));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Tomar pedido ✎", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(30, 30, 30));
        lblTitulo.setBounds(80, 20, 320, 35);
        panel.add(lblTitulo);

        JSeparator linea = new JSeparator();
        linea.setBounds(90, 58, 300, 2);
        linea.setForeground(new Color(60, 60, 60));
        panel.add(linea);

        JLabel lblMesa = new JLabel("Mesa 1 - cliente: Paula", SwingConstants.CENTER);
        lblMesa.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblMesa.setOpaque(true);
        lblMesa.setBackground(Color.WHITE);
        lblMesa.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 255), 2));
        lblMesa.setBounds(70, 70, 340, 30);
        panel.add(lblMesa);

        // Columnas solicitadas: Producto, valor, cantidad, actualizar
        String[] columnas = {"Producto", "valor", "cantidad", "actualizar"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnas);

        // Cargar los datos desde el almacenamiento compartido
        for (PedidoCompartido.ItemPedido item : PedidoCompartido.listaItems) {
            model.addRow(new Object[]{item.producto, item.valor, item.cantidad, "actualizar"});
        }

        JTable tabla = new JTable(model);
        tabla.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        tabla.setRowHeight(35);
        tabla.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        tabla.getTableHeader().setBackground(new Color(200, 200, 200));

        JScrollPane scrollTabla = new JScrollPane(tabla);
        scrollTabla.setBounds(20, 115, 435, 180);
        panel.add(scrollTabla);

        // Botón "Enviar pedido a cocina" (Verde éxito)
        JButton btnEnviar = new JButton("Enviar pedido a cocina");
        btnEnviar.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        btnEnviar.setBounds(30, 325, 200, 42);
        btnEnviar.setBackground(new Color(46, 139, 87));
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setFocusPainted(false);
        btnEnviar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        btnEnviar.addActionListener(e -> {
            new FrmPedidosCocina().setVisible(true);
            this.dispose();
        });
        panel.add(btnEnviar);

        // Campo Sub total dinámico con el valor real
        JLabel lblSubtotal = new JLabel(String.format("Sub total: %,.0f", PedidoCompartido.subtotalTotal), SwingConstants.CENTER);
        lblSubtotal.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        lblSubtotal.setOpaque(true);
        lblSubtotal.setBackground(Color.WHITE);
        lblSubtotal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        lblSubtotal.setBounds(250, 325, 190, 42);
        panel.add(lblSubtotal);

        // Botón de regreso al menú de platos
        JButton btnVolver = new JButton("Volver al menú de platos");
        btnVolver.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        btnVolver.setBackground(new Color(240, 140, 140));
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFocusPainted(false);
        btnVolver.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnVolver.setBounds(140, 390, 200, 38);
        
        btnVolver.addActionListener(e -> {
            new FrmTomarPedido().setVisible(true);
            this.dispose();
        });
        panel.add(btnVolver);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FrmResumenPedido().setVisible(true);
        });
    }
}