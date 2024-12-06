package productos;

public class Calzado extends ProductoBase {
    private String capellada;
    private String suela;
    private String cierre;

    public Calzado(String categoria, double precio) {
        super(categoria, precio);
    }

    public void personalizar(String capellada, String suela, String cierre) {
        this.capellada = capellada;
        this.suela = suela;
        this.cierre = cierre;
    }

    @Override
    public ProductoBase clonar() {
        Calzado clon = new Calzado(this.categoria, this.precio);
        clon.personalizar(this.capellada, this.suela, this.cierre);
        return clon;
    }

    @Override
    public String mostrarInformacion() {
        return "Categoria: " + categoria + ", Precio: " + precio + ", Capellada: " + capellada +
                ", Suela: " + suela + ", Cierre: " + cierre;
    }
}

