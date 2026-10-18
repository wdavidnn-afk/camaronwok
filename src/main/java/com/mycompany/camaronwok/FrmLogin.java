package com.mycompany.camaronwok;

import javax.swing.*;
import java.awt.*;

public class FrmLogin extends JFrame {

    public FrmLogin() {
        // Configuración general de la ventana
        setTitle("Camarón Wok - Ingresar");
        setSize(380, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en pantalla
        setResizable(false);

        // Panel principal con fondo azul pastel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(157, 195, 230)); // Azul claro suave
        panel.setLayout(null); // Layout libre

        // Título "Camarón Wok ⌂"
        JLabel lblTitulo = new JLabel("Camarón Wok ⌂", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(30, 30, 30));
        lblTitulo.setBounds(40, 35, 300, 35);
        panel.add(lblTitulo);

        // Línea divisora decorativa
        JSeparator linea = new JSeparator();
        linea.setBounds(60, 75, 260, 2);
        linea.setForeground(new Color(50, 50, 50));
        panel.add(linea);

        // Etiqueta Correo electrónico
        JLabel lblCorreo = new JLabel("Correo electrónico");
        lblCorreo.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        lblCorreo.setForeground(new Color(100, 100, 100));
        lblCorreo.setBounds(45, 110, 200, 20);
        panel.add(lblCorreo);

        // Campo de texto para Correo
        JTextField txtCorreo = new JTextField();
        txtCorreo.setBounds(45, 132, 290, 35);
        txtCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtCorreo.setBackground(Color.WHITE);
        txtCorreo.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 1));
        panel.add(txtCorreo);

        // Etiqueta Contraseña
        JLabel lblClave = new JLabel("Contraseña");
        lblClave.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        lblClave.setForeground(new Color(100, 100, 100));
        lblClave.setBounds(45, 185, 200, 20);
        panel.add(lblClave);

        // Campo para Contraseña
        JPasswordField txtClave = new JPasswordField();
        txtClave.setBounds(45, 207, 290, 35);
        txtClave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtClave.setBackground(Color.WHITE);
        txtClave.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 1));
        panel.add(txtClave);

        // Botón "Ingresar" cian/turquesa brillante
        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(120, 275, 140, 38);
        btnIngresar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        btnIngresar.setBackground(new Color(0, 255, 255)); // Cian
        btnIngresar.setForeground(Color.BLACK);
        btnIngresar.setFocusPainted(false);
        btnIngresar.setBorder(BorderFactory.createLineBorder(new Color(40, 40, 40), 1));
        panel.add(btnIngresar);

        // Agregar el panel a la ventana
        add(panel);
    }

    public static void main(String[] args) {
        // Ejecución directa de la ventana
        SwingUtilities.invokeLater(() -> {
            new FrmLogin().setVisible(true);
        });
    }
}