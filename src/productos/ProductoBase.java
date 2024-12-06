package productos;

public abstract class ProductoBase {
    protected String categoria;
    protected double precio;

    public ProductoBase(String categoria, double precio) {
        this.categoria = categoria;
        this.precio = precio;
    }

    public abstract String mostrarInformacion();

    public abstract ProductoBase clonar();
}
