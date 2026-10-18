package com.mycompany.camaronwok;

import javax.swing.*;
import java.awt.*;

public class FrmPedidosCocina extends JFrame {

    public FrmPedidosCocina() {
        // Configuración general de la ventana
        setTitle("Camarón Wok - Pedidos en Cocina");
        setSize(450, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en pantalla
        setResizable(false);

        // Panel principal con fondo azul pastel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(157, 195, 230)); // Azul suave pastel
        panel.setLayout(null);

        // Título principal
        JLabel lblTitulo = new JLabel("Pedidos en cocina", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(30, 30, 30));
        lblTitulo.setBounds(60, 20, 315, 35);
        panel.add(lblTitulo);

        // Línea divisora superior
        JSeparator lineaSuperior = new JSeparator();
        lineaSuperior.setBounds(70, 60, 295, 2);
        lineaSuperior.setForeground(new Color(60, 60, 60));
        panel.add(lineaSuperior);

        // --- PEDIDO 1 ---
        JLabel lblPedido1 = new JLabel("Mesa 1 - pedido #153 - Paula", SwingConstants.CENTER);
        lblPedido1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        lblPedido1.setOpaque(true);
        lblPedido1.setBackground(Color.WHITE);
        lblPedido1.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 255), 2)); // Borde cian
        lblPedido1.setBounds(25, 80, 270, 38);
        panel.add(lblPedido1);

        JButton btnEntregado1 = crearBotonEntregado();
        btnEntregado1.setBounds(305, 80, 105, 38);
        panel.add(btnEntregado1);

        // --- PEDIDO 2 ---
        JLabel lblPedido2 = new JLabel("Mesa 2 - pedido #150 - Anderson", SwingConstants.CENTER);
        lblPedido2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        lblPedido2.setOpaque(true);
        lblPedido2.setBackground(Color.WHITE);
        lblPedido2.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 255), 2)); // Borde cian
        lblPedido2.setBounds(25, 135, 270, 38);
        panel.add(lblPedido2);

        JButton btnEntregado2 = crearBotonEntregado();
        btnEntregado2.setBounds(305, 135, 105, 38);
        panel.add(btnEntregado2);

        // Línea divisora inferior
        JSeparator lineaInferior = new JSeparator();
        lineaInferior.setBounds(70, 195, 295, 2);
        lineaInferior.setForeground(new Color(60, 60, 60));
        panel.add(lineaInferior);

        // Mensaje de tiempo de entrega
        JLabel lblTiempo = new JLabel("<html><center>Tiempo de entrega de 10 a<br>15 minutos</center></html>", SwingConstants.CENTER);
        lblTiempo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        lblTiempo.setForeground(new Color(40, 40, 40));
        lblTiempo.setBounds(60, 215, 315, 55);
        panel.add(lblTiempo);

        // Botón "Volver al Inicio" (Rojo suave/Rosa)
        JButton btnVolver = new JButton("Volver al Inicio");
        btnVolver.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnVolver.setBackground(new Color(240, 140, 140)); // Rojo suave
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFocusPainted(false);
        btnVolver.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnVolver.setBounds(125, 330, 185, 42);
        panel.add(btnVolver);

        // Agregar panel a la ventana
        add(panel);
    }

    // Método auxiliar para crear los botones "Entregado" en Verde Medio Oscuro
    private JButton crearBotonEntregado() {
        JButton btn = new JButton("Entregado");
        btn.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        btn.setBackground(new Color(46, 139, 87)); // Verde medio oscuro (Éxito)
        btn.setForeground(Color.WHITE); // Texto blanco para contraste
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        return btn;
    }

    public static void main(String[] args) {
        // Ejecución directa de la ventana
        SwingUtilities.invokeLater(() -> {
            new FrmPedidosCocina().setVisible(true);
        });
    }
}