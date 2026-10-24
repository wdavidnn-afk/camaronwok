package com.mycompany.camaronwok;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmTomarPedido extends JFrame {

    private JButton btnEntradas, btnPlatos, btnBebidas, btnPostres;
    private JTable tablaMenu;
    private DefaultTableModel modeloMenu;
    
    // Modelo y tabla para la lista de agregados inferior
    private DefaultTableModel modeloAgregados;
    private JTable tablaAgregados;
    private JLabel lblSubtotal;
    private double subtotalGeneral = 0.0;

    public FrmTomarPedido() {
        setTitle("Camarón Wok - Tomar Pedido");
        setSize(480, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(220, 220, 220));
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Tomar pedido ✎", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(30, 30, 30));
        lblTitulo.setBounds(80, 15, 320, 35);
        panel.add(lblTitulo);

        JSeparator linea = new JSeparator();
        linea.setBounds(90, 52, 300, 2);
        linea.setForeground(new Color(60, 60, 60));
        panel.add(linea);

        JLabel lblMesa = new JLabel("Mesa 1 - cliente: Paula", SwingConstants.CENTER);
        lblMesa.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblMesa.setOpaque(true);
        lblMesa.setBackground(Color.WHITE);
        lblMesa.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 255), 2));
        lblMesa.setBounds(70, 62, 340, 30);
        panel.add(lblMesa);

        // --- PESTAÑAS SUPERIORES ---
        btnEntradas = crearBotonPestaña("Entradas", true);
        btnEntradas.setBounds(20, 105, 105, 30);
        panel.add(btnEntradas);

        btnPlatos = crearBotonPestaña("Platos fuertes", false);
        btnPlatos.setBounds(130, 105, 115, 30);
        panel.add(btnPlatos);

        btnBebidas = crearBotonPestaña("Bebidas", false);
        btnBebidas.setBounds(250, 105, 100, 30);
        panel.add(btnBebidas);

        btnPostres = crearBotonPestaña("Postres", false);
        btnPostres.setBounds(355, 105, 100, 30);
        panel.add(btnPostres);

        // Acciones al cambiar de categoría
        btnEntradas.addActionListener(e -> cambiarCategoria("Entradas"));
        btnPlatos.addActionListener(e -> cambiarCategoria("Platos fuertes"));
        btnBebidas.addActionListener(e -> cambiarCategoria("Bebidas"));
        btnPostres.addActionListener(e -> cambiarCategoria("Postres"));

        // Tabla Superior (Menú con ComboBox de cantidad 1 a 5 y Botón Agregar)
        modeloMenu = new DefaultTableModel(new Object[][]{
            {"Ceviche Camarón Wok", "28.000", 1, "agregar"},
            {"Dumplings de Cerdo", "18.000", 1, "agregar"}
        }, new String[]{"Entradas", "valor", "cantidad", "acción"});

        tablaMenu = new JTable(modeloMenu);
        configurarTablaMenu();

        JScrollPane scrollMenu = new JScrollPane(tablaMenu);
        scrollMenu.setBounds(20, 145, 435, 90);
        panel.add(scrollMenu);

        // Sección "LISTA DE AGREGADO"
        JLabel lblListaAgregado = new JLabel("LISTA DE AGREGADO");
        lblListaAgregado.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblListaAgregado.setOpaque(true);
        lblListaAgregado.setBackground(new Color(0, 255, 255));
        lblListaAgregado.setBounds(30, 248, 170, 25);
        panel.add(lblListaAgregado);

        // Tabla Inferior (Lista de productos agregados al pedido)
        modeloAgregados = new DefaultTableModel(new Object[][]{}, new String[]{"Producto", "valor", "cant", "total"});
        tablaAgregados = new JTable(modeloAgregados);
        tablaAgregados.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        tablaAgregados.setRowHeight(25);
        tablaAgregados.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 12));

        JScrollPane scrollAgregados = new JScrollPane(tablaAgregados);
        scrollAgregados.setBounds(20, 278, 435, 105);
        panel.add(scrollAgregados);

        // Botón "Quitar de la lista" (Amarillo)
        JButton btnQuitar = new JButton("Quitar de la lista");
        btnQuitar.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        btnQuitar.setBackground(new Color(255, 255, 0));
        btnQuitar.setForeground(Color.BLACK);
        btnQuitar.setFocusPainted(false);
        btnQuitar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnQuitar.setBounds(240, 395, 180, 32);
        btnQuitar.addActionListener(e -> quitarProductoSeleccionado());
        panel.add(btnQuitar);

        // Botón "Volver al estado de mesas" (Rojo suave)
        JButton btnVolver = new JButton("Volver al estado de mesas");
        btnVolver.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
        btnVolver.setBackground(new Color(240, 140, 140));
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFocusPainted(false);
        btnVolver.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnVolver.setBounds(30, 440, 190, 35);
        btnVolver.addActionListener(e -> {
            new FrmEstadoMesas().setVisible(true);
            this.dispose();
        });
        panel.add(btnVolver);

        // Campo Sub total dinámico
        lblSubtotal = new JLabel("Sub total: 0", SwingConstants.CENTER);
        lblSubtotal.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        lblSubtotal.setOpaque(true);
        lblSubtotal.setBackground(Color.WHITE);
        lblSubtotal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        lblSubtotal.setBounds(240, 440, 190, 35);
        panel.add(lblSubtotal);

        // Botón "Lista de productos" (Verde claro) con el almacenamiento compartido integrado
        JButton btnListaProductos = new JButton("Lista de productos");
        btnListaProductos.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnListaProductos.setBackground(new Color(150, 210, 130));
        btnListaProductos.setForeground(Color.BLACK);
        btnListaProductos.setFocusPainted(false);
        btnListaProductos.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btnListaProductos.setBounds(130, 490, 210, 38);
        
        btnListaProductos.addActionListener(e -> {
            // Guardar los datos de la tabla de agregados en el almacenamiento compartido
            PedidoCompartido.listaItems.clear();
            for (int i = 0; i < modeloAgregados.getRowCount(); i++) {
                String prod = modeloAgregados.getValueAt(i, 0).toString();
                String val = modeloAgregados.getValueAt(i, 1).toString();
                int cant = Integer.parseInt(modeloAgregados.getValueAt(i, 2).toString());
                double totalF = Double.parseDouble(modeloAgregados.getValueAt(i, 3).toString().replace(".", "").replace(",", ""));
                PedidoCompartido.listaItems.add(new PedidoCompartido.ItemPedido(prod, val, cant, totalF));
            }
            PedidoCompartido.subtotalTotal = subtotalGeneral;

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

    private void cambiarCategoria(String categoria) {
        btnEntradas.setBackground(Color.WHITE);
        btnPlatos.setBackground(Color.WHITE);
        btnBebidas.setBackground(Color.WHITE);
        btnPostres.setBackground(Color.WHITE);

        Object[][] datos;

        if (categoria.equals("Entradas")) {
            btnEntradas.setBackground(new Color(140, 170, 230));
            datos = new Object[][]{
                {"Ceviche Camarón Wok", "28.000", 1, "agregar"},
                {"Dumplings de Cerdo", "18.000", 1, "agregar"}
            };
        } else if (categoria.equals("Platos fuertes")) {
            btnPlatos.setBackground(new Color(140, 170, 230));
            datos = new Object[][]{
                {"Wok Camarón Especial", "35.000", 1, "agregar"},
                {"Pad Thai de Mariscos", "38.000", 1, "agregar"},
                {"Lomo Saltado Oriental", "36.000", 1, "agregar"}
            };
        } else if (categoria.equals("Bebidas")) {
            btnBebidas.setBackground(new Color(140, 170, 230));
            datos = new Object[][]{
                {"Margarita de Maracuyá", "22.000", 1, "agregar"},
                {"Limonada de Coco", "12.000", 1, "agregar"}
            };
        } else {
            btnPostres.setBackground(new Color(140, 170, 230));
            datos = new Object[][]{
                {"Mochi de Té Verde", "14.000", 1, "agregar"}
            };
        }

        modeloMenu.setDataVector(datos, new String[]{categoria, "valor", "cantidad", "acción"});
        configurarTablaMenu();
    }

    private void configurarTablaMenu() {
        tablaMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        tablaMenu.setRowHeight(30);
        tablaMenu.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 13));
        tablaMenu.getTableHeader().setBackground(new Color(200, 200, 200));

        // Columna 2: Cantidad con ComboBox (del 1 al 5)
        Integer[] cantidades = {1, 2, 3, 4, 5};
        JComboBox<Integer> comboCantidad = new JComboBox<>(cantidades);
        tablaMenu.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboCantidad));

        // Columna 3: Botón Agregar interactivo
        tablaMenu.getColumnModel().getColumn(3).setCellRenderer(new BotonRender());
        tablaMenu.getColumnModel().getColumn(3).setCellEditor(new BotonEditor(new JCheckBox(), this));
    }

    public void agregarProductoAlPedido(int fila) {
        try {
            String producto = modeloMenu.getValueAt(fila, 0).toString();
            String valorStr = modeloMenu.getValueAt(fila, 1).toString().replace(".", "");
            double valorUnitario = Double.parseDouble(valorStr);
            
            Object cantObj = modeloMenu.getValueAt(fila, 2);
            int cantidad = (cantObj != null) ? Integer.parseInt(cantObj.toString()) : 1;

            double totalFila = valorUnitario * cantidad;

            modeloAgregados.addRow(new Object[]{producto, modeloMenu.getValueAt(fila, 1), cantidad, String.format("%,.0f", totalFila)});

            subtotalGeneral += totalFila;
            lblSubtotal.setText(String.format("Sub total: %,.0f", subtotalGeneral));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al agregar el producto.");
        }
    }

    private void quitarProductoSeleccionado() {
        int filaSeleccionada = tablaAgregados.getSelectedRow();
        if (filaSeleccionada >= 0) {
            try {
                String totalStr = modeloAgregados.getValueAt(filaSeleccionada, 3).toString().replace(".", "").replace(",", "");
                double totalFila = Double.parseDouble(totalStr);
                subtotalGeneral -= totalFila;
                lblSubtotal.setText(String.format("Sub total: %,.0f", subtotalGeneral));
            } catch (Exception ignored) {}

            modeloAgregados.removeRow(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un producto de la lista de agregado para quitar.");
        }
    }

    class BotonRender extends JButton implements TableCellRenderer {
        public BotonRender() {
            setOpaque(true);
            setFont(new Font("Comic Sans MS", Font.BOLD, 12));
            setBackground(new Color(0, 255, 255));
            setForeground(Color.BLACK);
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value != null ? value.toString() : "agregar");
            return this;
        }
    }

    class BotonEditor extends DefaultCellEditor {
        private JButton boton;
        private String etiqueta;
        private boolean clicked;
        private int filaActual;
        private FrmTomarPedido ventana;

        public BotonEditor(JCheckBox checkBox, FrmTomarPedido ventana) {
            super(checkBox);
            this.ventana = ventana;
            boton = new JButton();
            boton.setOpaque(true);
            boton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
            boton.setBackground(new Color(0, 255, 255));
            boton.setForeground(Color.BLACK);
            boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            filaActual = row;
            etiqueta = (value == null) ? "agregar" : value.toString();
            boton.setText(etiqueta);
            clicked = true;
            return boton;
        }

        @Override
        public Object getCellEditorValue() {
            if (clicked) {
                ventana.agregarProductoAlPedido(filaActual);
            }
            clicked = false;
            return etiqueta;
        }

        @Override
        public boolean stopCellEditing() {
            clicked = false;
            return super.stopCellEditing();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FrmTomarPedido().setVisible(true);
        });
    }
}