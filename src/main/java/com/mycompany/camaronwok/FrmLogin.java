package com.mycompany.camaronwok;

import javax.swing.*;
import java.awt.*;

public class FrmLogin extends JFrame {

    public FrmLogin() {
        setTitle("Camarón Wok - Inicio de Sesión");
        setSize(400, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(157, 195, 230));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Inicio de usuario 👤", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(40, 40, 40));
        lblTitulo.setBounds(40, 30, 320, 35);
        panel.add(lblTitulo);

        JSeparator linea = new JSeparator();
        linea.setBounds(50, 70, 300, 2);
        linea.setForeground(new Color(50, 50, 50));
        panel.add(linea);

        JLabel lblUser = new JLabel("Usuario:");
        lblUser.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblUser.setBounds(50, 95, 300, 25);
        panel.add(lblUser);

        JTextField txtUser = new JTextField();
        txtUser.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        txtUser.setBounds(50, 125, 300, 35);
        txtUser.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 50), 1));
        panel.add(txtUser);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblPass.setBounds(50, 175, 300, 25);
        panel.add(lblPass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        txtPass.setBounds(50, 205, 300, 35);
        txtPass.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 50), 1));
        panel.add(txtPass);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        btnIngresar.setBackground(new Color(0, 255, 255));
        btnIngresar.setForeground(Color.BLACK);
        btnIngresar.setFocusPainted(false);
        btnIngresar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnIngresar.setBounds(110, 280, 180, 42);

        // CONEXIÓN: Abre el menú principal y cierra el login
        btnIngresar.addActionListener(e -> {
            new FrmInicioUsuario().setVisible(true);
            this.dispose();
        });

        panel.add(btnIngresar);
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmLogin().setVisible(true));
    }
}