package com.mycompany.camaronwok;

import javax.swing.*;
import java.awt.*;

public class FrmInicioUsuario extends JFrame {

    public FrmInicioUsuario() {
        // Configuración general de la ventana
        setTitle("Camarón Wok - Inicio de Usuario");
        setSize(420, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en pantalla
        setResizable(false);

        // Panel principal con fondo azul pastel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(157, 195, 230)); // Azul suave pastel
        panel.setLayout(null);

        // Título "Inicio de usuario 👤"
        JLabel lblTitulo = new JLabel("Inicio de usuario 👤", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(30, 30, 30));
        lblTitulo.setBounds(50, 25, 300, 35);
        panel.add(lblTitulo);

        // Línea divisora decorativa
        JSeparator linea = new JSeparator();
        linea.setBounds(60, 65, 280, 2);
        linea.setForeground(new Color(50, 50, 50));
        panel.add(linea);

        // Menú de Opciones (Botones con fondo blanco neutro)
        int anchoBoton = 220;
        int altoBoton = 40;
        int xPos = (420 - anchoBoton) / 2; // Centrado horizontalmente

        JButton btnEstadoMesas = crearBotonMenu("Estado de mesas");
        btnEstadoMesas.setBounds(xPos, 95, anchoBoton, altoBoton);
        panel.add(btnEstadoMesas);

        JButton btnTomarPedido = crearBotonMenu("Tomar pedido");
        btnTomarPedido.setBounds(xPos, 140, anchoBoton, altoBoton);
        panel.add(btnTomarPedido);

        JButton btnCocina = crearBotonMenu("Cocina");
        btnCocina.setBounds(xPos, 185, anchoBoton, altoBoton);
        panel.add(btnCocina);

        JButton btnCaja = crearBotonMenu("Caja");
        btnCaja.setBounds(xPos, 230, anchoBoton, altoBoton);
        panel.add(btnCaja);

        // Agregar panel a la ventana
        add(panel);
    }

    // Método auxiliar para dar formato uniforme y limpio a los botones
    private JButton crearBotonMenu(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        btn.setBackground(Color.WHITE); // Fondo blanco limpio sin resaltar ninguno
        btn.setForeground(new Color(30, 30, 30));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 1));
        return btn;
    }

    public static void main(String[] args) {
        // Ejecución directa de la ventana
        SwingUtilities.invokeLater(() -> {
            new FrmInicioUsuario().setVisible(true);
        });
    }
}