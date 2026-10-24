package com.mycompany.camaronwok;

import javax.swing.*;
import java.awt.*;

public class FrmCaja extends JFrame {
    public FrmCaja() {
        setTitle("Camarón Wok - Caja");
        setSize(480, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(157, 195, 230));
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmCaja().setVisible(true));
    }
}