package Pedidos;

import productos.ProductoBase;

public class Pedido {
    private final int id;
    private final ProductoBase producto;
    private String estado;

    public Pedido(int id, ProductoBase producto, String estado) {
        this.id = id;
        this.producto = producto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public ProductoBase getProducto() {
        return producto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido ID: " + id + ", Estado: " + estado + ", Producto: [" + producto.mostrarInformacion() + "]";
    }
}
