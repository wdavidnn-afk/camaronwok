package com.mycompany.camaronwok;

import javax.swing.*;
import java.awt.*;

public class FrmEstadoMesas extends JFrame {

    public FrmEstadoMesas() {
        // Configuración general de la ventana
        setTitle("Camarón Wok - Estado de Mesas");
        setSize(460, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en pantalla
        setResizable(false);

        // Panel principal con fondo azul pastel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(157, 195, 230)); // Azul suave pastel
        panel.setLayout(null);

        // Título "Estado de mesas 👤"
        JLabel lblTitulo = new JLabel("Estado de mesas 👤", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(30, 30, 30));
        lblTitulo.setBounds(70, 25, 320, 35);
        panel.add(lblTitulo);

        // Línea divisora decorativa
        JSeparator linea = new JSeparator();
        linea.setBounds(80, 65, 300, 2);
        linea.setForeground(new Color(50, 50, 50));
        panel.add(linea);

        // Grid de Mesas (Todas Disponibles - Verde Claro)
        // Fila 1
        panel.add(crearBotonMesa("Mesa 1", "Cap. 4", "Disponible", 50, 95));
        panel.add(crearBotonMesa("Mesa 2", "Cap. 2", "Disponible", 240, 95));

        // Fila 2
        panel.add(crearBotonMesa("Mesa 3", "Cap. 6", "Disponible", 50, 215));
        panel.add(crearBotonMesa("Mesa 4", "Cap. 2", "Disponible", 240, 215));

        // Fila 3
        panel.add(crearBotonMesa("Mesa 5", "Cap. 8", "Disponible", 50, 335));

        // Botón "+ Nuevo Pedido" (Verde Oscuro)
        JButton btnNuevoPedido = new JButton("<html><center><b>+ Nuevo<br>Pedido</b></center></html>");
        btnNuevoPedido.setBounds(240, 335, 160, 100);
        btnNuevoPedido.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        btnNuevoPedido.setBackground(new Color(40, 120, 40)); // Verde oscuro
        btnNuevoPedido.setForeground(Color.WHITE);
        btnNuevoPedido.setFocusPainted(false);
        btnNuevoPedido.setBorder(BorderFactory.createLineBorder(new Color(30, 30, 30), 1));
        panel.add(btnNuevoPedido);

        // Agregar panel a la ventana
        add(panel);
    }

    // Método auxiliar para construir los botones de las mesas en verde pastel "Disponible"
    private JButton crearBotonMesa(String nombre, String capacidad, String estado, int x, int y) {
        String textoHtml = "<html><center><b>" + nombre + "</b><br>" + capacidad + "<br><b>" + estado + "</b></center></html>";
        JButton btn = new JButton(textoHtml);
        btn.setBounds(x, y, 160, 100);
        btn.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        
        // Color verde suave para "Disponible"
        btn.setBackground(new Color(180, 220, 160)); 
        btn.setForeground(new Color(30, 30, 30));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 50), 1));
        return btn;
    }

    public static void main(String[] args) {
        // Ejecución directa de la ventana
        SwingUtilities.invokeLater(() -> {
            new FrmEstadoMesas().setVisible(true);
        });
    }
}