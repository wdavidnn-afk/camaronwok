package com.mycompany.camaronwok;

import java.util.ArrayList;
import java.util.List;

public class PedidoCompartido {
    public static class ItemPedido {
        public String producto;
        public String valor;
        public int cantidad;
        public double total;

        public ItemPedido(String producto, String valor, int cantidad, double total) {
            this.producto = producto;
            this.valor = valor;
            this.cantidad = cantidad;
            this.total = total;
        }
    }

    public static List<ItemPedido> listaItems = new ArrayList<>();
    public static double subtotalTotal = 0.0;
}