package productos;

public abstract class ProductoBuilder {
    protected ProductoBase producto;

    public void crearProductoBase(String categoria, double precio) {
        producto = FabricaDeProductos.crearProducto(categoria, precio);
    }

    public ProductoBase obtenerProducto() {
        return producto;
    }

    public abstract void personalizar();
}
