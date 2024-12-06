package Pedidos;

import productos.ProductoBase;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDePedidos {
    private static AdministradorDePedidos instancia;
    private final List<Pedido> pedidos;
    private int idCounter;

    private AdministradorDePedidos() {
        this.pedidos = new ArrayList<>();
        this.idCounter = 1;
    }

    public static AdministradorDePedidos getInstance() {
        if (instancia == null) {
            instancia = new AdministradorDePedidos();
        }
        return instancia;
    }

    public void agregarPedido(ProductoBase producto) {
        Pedido nuevoPedido = new Pedido(idCounter++, producto, "en proceso");
        pedidos.add(nuevoPedido);
    }

    public void actualizarEstadoPedido(int id, String nuevoEstado) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                pedido.setEstado(nuevoEstado);
                return;
            }
        }
        System.out.println("Pedido no encontrado.");
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void mostrarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }
}

