package com.mycompany.camaronwok;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrmTomarPedidoEntradas extends JFrame {

    public FrmTomarPedidoEntradas() {
        // Configuración general de la ventana
        setTitle("Camarón Wok - Tomar Pedido");
        setSize(480, 580);
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

        // Línea divisora
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

        // Pestañas / Categorías
        JButton btnEntradas = crearBotonPestaña("Entradas", true);
        btnEntradas.setBounds(20, 115, 105, 30);
        panel.add(btnEntradas);

        JButton btnPlatos = crearBotonPestaña("Platos fuertes", false);
        btnPlatos.setBounds(130, 115, 115, 30);
        panel.add(btnPlatos);

        JButton btnBebidas = crearBotonPestaña("Bebidas", false);
        btnBebidas.setBounds(250, 115, 100, 30);
        panel.add(btnBebidas);

        JButton btnPostres = crearBotonPestaña("Postres", false);
        btnPostres.setBounds(355, 115, 100, 30);
        panel.add(btnPostres);

        // Tabla de selección de producto (Completamente vacía)
        String[] columnas = {"Entradas", "valor", "cantidad", "acción"};
        Object[][] datos = {
            {"", "", "", "agregar"}
        };

        DefaultTableModel model = new DefaultTableModel(datos, columnas);
        JTable tabla = new JTable(model);
        tabla.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        tabla.setRowHeight(35);
        tabla.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        tabla.getTableHeader().setBackground(new Color(200, 200, 200));

        // Alineación y estilo personalizado para el botón agregar dentro de la tabla
        tabla.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JButton btn = new JButton(value.toString());
                btn.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
                btn.setBackground(new Color(0, 255, 255)); // Cian
                btn.setForeground(Color.BLACK);
                btn.setFocusPainted(false);
                btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                return btn;
            }
        });

        JScrollPane scrollTabla = new JScrollPane(tabla);
        scrollTabla.setBounds(20, 155, 435, 65);
        panel.add(scrollTabla);

        // Sección "LISTA DE AGREGADO"
        JLabel lblListaAgregado = new JLabel("LISTA DE AGREGADO");
        lblListaAgregado.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblListaAgregado.setOpaque(true);
        lblListaAgregado.setBackground(new Color(0, 255, 255)); // Fondo cian
        lblListaAgregado.setBounds(40, 240, 190, 25);
        panel.add(lblListaAgregado);

        // Botón "Quitar de la lista" (Amarillo)
        JButton btnQuitar = new JButton("Quitar de la lista");
        btnQuitar.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        btnQuitar.setBackground(new Color(255, 255, 0)); // Amarillo
        btnQuitar.setForeground(Color.BLACK);
        btnQuitar.setFocusPainted(false);
        btnQuitar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnQuitar.setBounds(240, 280, 180, 35);
        panel.add(btnQuitar);

        // Botón "Volver al estado de mesas" (Rojo suave)
        JButton btnVolver = new JButton("Volver al estado de mesas");
        btnVolver.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        btnVolver.setBackground(new Color(240, 140, 140)); // Rojo suave
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFocusPainted(false);
        btnVolver.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnVolver.setBounds(30, 350, 200, 38);
        panel.add(btnVolver);

        // Campo Sub total en 0
        JLabel lblSubtotal = new JLabel("Sub total: 0", SwingConstants.CENTER);
        lblSubtotal.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        lblSubtotal.setOpaque(true);
        lblSubtotal.setBackground(Color.WHITE);
        lblSubtotal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        lblSubtotal.setBounds(250, 350, 170, 38);
        panel.add(lblSubtotal);

        // Botón "Lista de productos" (Verde claro)
        JButton btnListaProductos = new JButton("Lista de productos");
        btnListaProductos.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        btnListaProductos.setBackground(new Color(150, 210, 130)); // Verde claro
        btnListaProductos.setForeground(Color.BLACK);
        btnListaProductos.setFocusPainted(false);
        btnListaProductos.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnListaProductos.setBounds(130, 420, 210, 42);
        panel.add(btnListaProductos);

        // Agregar panel principal a la ventana
        add(panel);
    }

    // Método auxiliar para estilo de las pestañas
    private JButton crearBotonPestaña(String texto, boolean seleccionada) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        if (seleccionada) {
            btn.setBackground(new Color(140, 170, 230)); // Azul seleccionado
        } else {
            btn.setBackground(Color.WHITE);
        }
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        return btn;
    }

    public static void main(String[] args) {
        // Ejecución directa de la ventana
        SwingUtilities.invokeLater(() -> {
            new FrmTomarPedidoEntradas().setVisible(true);
        });
    }
}