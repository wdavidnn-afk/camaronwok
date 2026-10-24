package com.mycompany.camaronwok;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FrmTomarPedido extends JFrame {

    private JButton btnEntradas, btnPlatos, btnBebidas, btnPostres;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public FrmTomarPedido() {
        setTitle("Camarón Wok - Tomar Pedido");
        setSize(480, 580);
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

        // --- PESTAÑAS SUPERIORES ---
        btnEntradas = crearBotonPestaña("Entradas", true);
        btnEntradas.setBounds(20, 115, 105, 30);
        panel.add(btnEntradas);

        btnPlatos = crearBotonPestaña("Platos fuertes", false);
        btnPlatos.setBounds(130, 115, 115, 30);
        panel.add(btnPlatos);

        btnBebidas = crearBotonPestaña("Bebidas", false);
        btnBebidas.setBounds(250, 115, 100, 30);
        panel.add(btnBebidas);

        btnPostres = crearBotonPestaña("Postres", false);
        btnPostres.setBounds(355, 115, 100, 30);
        panel.add(btnPostres);

        // Acciones al cambiar de categoría
        btnEntradas.addActionListener(e -> cambiarCategoria("Entradas"));
        btnPlatos.addActionListener(e -> cambiarCategoria("Platos fuertes"));
        btnBebidas.addActionListener(e -> cambiarCategoria("Bebidas"));
        btnPostres.addActionListener(e -> cambiarCategoria("Postres"));

        // Tabla inicial con Entradas
        modeloTabla = new DefaultTableModel(new Object[][]{
            {"Ceviche Camarón Wok", "28.000", "1", "agregar"},
            {"Dumplings de Cerdo", "18.000", "1", "agregar"}
        }, new String[]{"Entradas", "valor", "cantidad", "acción"});

        tabla = new JTable(modeloTabla);
        configurarTabla();

        JScrollPane scrollTabla = new JScrollPane(tabla);
        scrollTabla.setBounds(20, 155, 435, 95);
        panel.add(scrollTabla);

        JLabel lblListaAgregado = new JLabel("LISTA DE AGREGADO");
        lblListaAgregado.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblListaAgregado.setOpaque(true);
        lblListaAgregado.setBackground(new Color(0, 255, 255));
        lblListaAgregado.setBounds(40, 260, 190, 25);
        panel.add(lblListaAgregado);

        JButton btnQuitar = new JButton("Quitar de la lista");
        btnQuitar.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        btnQuitar.setBackground(new Color(255, 255, 0));
        btnQuitar.setForeground(Color.BLACK);
        btnQuitar.setFocusPainted(false);
        btnQuitar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnQuitar.setBounds(240, 295, 180, 35);
        panel.add(btnQuitar);

        JButton btnVolver = new JButton("Volver al estado de mesas");
        btnVolver.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        btnVolver.setBackground(new Color(240, 140, 140));
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFocusPainted(false);
        btnVolver.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnVolver.setBounds(30, 360, 200, 38);
        btnVolver.addActionListener(e -> {
            new FrmEstadoMesas().setVisible(true);
            this.dispose();
        });
        panel.add(btnVolver);

        JLabel lblSubtotal = new JLabel("Sub total: 0", SwingConstants.CENTER);
        lblSubtotal.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        lblSubtotal.setOpaque(true);
        lblSubtotal.setBackground(Color.WHITE);
        lblSubtotal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        lblSubtotal.setBounds(250, 360, 170, 38);
        panel.add(lblSubtotal);

        JButton btnListaProductos = new JButton("Lista de productos");
        btnListaProductos.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        btnListaProductos.setBackground(new Color(150, 210, 130));
        btnListaProductos.setForeground(Color.BLACK);
        btnListaProductos.setFocusPainted(false);
        btnListaProductos.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnListaProductos.setBounds(130, 430, 210, 42);
        btnListaProductos.addActionListener(e -> {
            new FrmResumenPedido().setVisible(true);
            this.dispose();
        });
        panel.add(btnListaProductos);

        add(panel);
    }

    private JButton crearBotonPestaña(String texto, boolean seleccionada) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        btn.setBackground(seleccionada ? new Color(140, 170, 230) : Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        return btn;
    }

    // Método dinámico para cambiar el color de las pestañas y el contenido de la tabla según la categoría
    private void cambiarCategoria(String categoria) {
        // Apagar todos los botones (blanco)
        btnEntradas.setBackground(Color.WHITE);
        btnPlatos.setBackground(Color.WHITE);
        btnBebidas.setBackground(Color.WHITE);
        btnPostres.setBackground(Color.WHITE);

        Object[][] datos;

        if (categoria.equals("Entradas")) {
            btnEntradas.setBackground(new Color(140, 170, 230));
            datos = new Object[][]{
                {"Ceviche Camarón Wok", "28.000", "1", "agregar"},
                {"Dumplings de Cerdo", "18.000", "1", "agregar"}
            };
        } else if (categoria.equals("Platos fuertes")) {
            btnPlatos.setBackground(new Color(140, 170, 230));
            datos = new Object[][]{
                {"Wok Camarón Especial", "35.000", "1", "agregar"},
                {"Pad Thai de Mariscos", "38.000", "1", "agregar"},
                {"Lomo Saltado Oriental", "36.000", "1", "agregar"}
            };
        } else if (categoria.equals("Bebidas")) {
            btnBebidas.setBackground(new Color(140, 170, 230));
            datos = new Object[][]{
                {"Margarita de Maracuyá", "22.000", "1", "agregar"},
                {"Limonada de Coco", "12.000", "1", "agregar"}
            };
        } else { // Postres
            btnPostres.setBackground(new Color(140, 170, 230));
            datos = new Object[][]{
                {"Mochi de Té Verde", "14.000", "1", "agregar"}
            };
        }

        // Actualizar la tabla con la nueva categoría y sus respectivos productos
        modeloTabla.setDataVector(datos, new String[]{categoria, "valor", "cantidad", "acción"});
        configurarTabla();
    }

    private void configurarTabla() {
        tabla.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        tabla.setRowHeight(35);
        tabla.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        tabla.getTableHeader().setBackground(new Color(200, 200, 200));

        tabla.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JButton btn = new JButton(value != null ? value.toString() : "agregar");
                btn.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
                btn.setBackground(new Color(0, 255, 255));
                btn.setForeground(Color.BLACK);
                btn.setFocusPainted(false);
                btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                return btn;
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FrmTomarPedido().setVisible(true);
        });
    }
}