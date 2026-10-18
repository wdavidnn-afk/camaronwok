package com.mycompany.camaronwok;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrmResumenPedido extends JFrame {

    public FrmResumenPedido() {
        // Configuración general de la ventana
        setTitle("Camarón Wok - Tomar Pedido (Resumen)");
        setSize(480, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en pantalla
        setResizable(false);

        // Panel principal con fondo gris suave
        JPanel panel = new JPanel();
        panel.setBackground(new Color(220, 220, 220));
        panel.setLayout(null);

        // Título "Tomar pedido ✎"
        JLabel lblTitulo = new JLabel("Tomar pedido ✎", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(30, 30, 30));
        lblTitulo.setBounds(80, 20, 320, 35);
        panel.add(lblTitulo);

        // Línea divisora decorativa
        JSeparator linea = new JSeparator();
        linea.setBounds(90, 58, 300, 2);
        linea.setForeground(new Color(60, 60, 60));
        panel.add(linea);

        // Subtítulo de Mesa y Cliente
        JLabel lblMesa = new JLabel("Mesa 1 - cliente: Paula", SwingConstants.CENTER);
        lblMesa.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblMesa.setOpaque(true);
        lblMesa.setBackground(Color.WHITE);
        lblMesa.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 255), 2)); // Borde cian
        lblMesa.setBounds(70, 70, 340, 30);
        panel.add(lblMesa);

        // Tabla de Pedido (Completamente vacía con una fila en blanco)
        String[] columnas = {"Producto", "valor", "cantidad", "actualizar"};
        Object[][] datos = {
            {"", "", "", ""}
        };

        DefaultTableModel model = new DefaultTableModel(datos, columnas);
        JTable tabla = new JTable(model);
        tabla.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        tabla.setRowHeight(40);
        tabla.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        tabla.getTableHeader().setBackground(new Color(200, 200, 200));

        JScrollPane scrollTabla = new JScrollPane(tabla);
        scrollTabla.setBounds(20, 115, 435, 220);
        panel.add(scrollTabla);

        // Botón "Enviar pedido a cocina" (Deshabilitado / Apagado)
        JButton btnEnviar = new JButton("Enviar pedido a cocina");
        btnEnviar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnEnviar.setBounds(30, 370, 220, 42);
        btnEnviar.setEnabled(false); // Deshabilitar botón
        btnEnviar.setBackground(new Color(180, 180, 180)); // Fondo gris deshabilitado
        btnEnviar.setForeground(new Color(100, 100, 100));
        btnEnviar.setFocusPainted(false);
        btnEnviar.setBorder(BorderFactory.createLineBorder(new Color(120, 120, 120), 1));
        panel.add(btnEnviar);

        // Campo Sub total en 0
        JLabel lblSubtotal = new JLabel("Sub total: 0", SwingConstants.CENTER);
        lblSubtotal.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        lblSubtotal.setOpaque(true);
        lblSubtotal.setBackground(Color.WHITE);
        lblSubtotal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        lblSubtotal.setBounds(265, 370, 180, 42);
        panel.add(lblSubtotal);

        // Agregar panel principal a la ventana
        add(panel);
    }

    public static void main(String[] args) {
        // Ejecución directa de la ventana
        SwingUtilities.invokeLater(() -> {
            new FrmResumenPedido().setVisible(true);
        });
    }
}