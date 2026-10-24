package com.mycompany.camaronwok;

import javax.swing.*;
import java.awt.*;

public class FrmInicioUsuario extends JFrame {

    public FrmInicioUsuario() {
        setTitle("Camarón Wok - Menú Principal");
        setSize(480, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(157, 195, 230));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Camarón Wok", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(30, 30, 30));
        lblTitulo.setBounds(80, 20, 320, 35);
        panel.add(lblTitulo);

        JSeparator linea = new JSeparator();
        linea.setBounds(90, 58, 300, 2);
        linea.setForeground(new Color(60, 60, 60));
        panel.add(linea);

        // 1. Ir a Estado de Mesas
        JButton btnMesas = new JButton("1. Estado de Mesas");
        btnMesas.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnMesas.setBounds(100, 90, 280, 40);
        btnMesas.addActionListener(e -> {
            new FrmEstadoMesas().setVisible(true);
            this.dispose();
        });
        panel.add(btnMesas);

        // 2. Ir a Tomar Pedido
        JButton btnTomarPedido = new JButton("2. Tomar Pedido");
        btnTomarPedido.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnTomarPedido.setBounds(100, 150, 280, 40);
        btnTomarPedido.addActionListener(e -> {
            new FrmTomarPedido().setVisible(true);
            this.dispose();
        });
        panel.add(btnTomarPedido);

        // 3. Ir a Pedidos en Cocina
        JButton btnCocina = new JButton("3. Pedidos en Cocina");
        btnCocina.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnCocina.setBounds(100, 210, 280, 40);
        btnCocina.addActionListener(e -> {
            new FrmPedidosCocina().setVisible(true);
            this.dispose();
        });
        panel.add(btnCocina);

        // 4. Ir a Caja / Factura
        JButton btnCaja = new JButton("4. Caja y Facturación");
        btnCaja.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnCaja.setBounds(100, 270, 280, 40);
        btnCaja.addActionListener(e -> {
            new FrmCaja().setVisible(true);
            this.dispose();
        });
        panel.add(btnCaja);

        // Botón de Cerrar Sesión (Regresa al Login)
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        btnCerrarSesion.setBackground(new Color(240, 140, 140));
        btnCerrarSesion.setBounds(160, 350, 160, 35);
        btnCerrarSesion.addActionListener(e -> {
            new FrmLogin().setVisible(true);
            this.dispose();
        });
        panel.add(btnCerrarSesion);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmInicioUsuario().setVisible(true));
    }
}