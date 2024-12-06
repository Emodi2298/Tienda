package productos;

public class Ropa extends ProductoBase {
    private String color;
    private String telaNombre;
    private String telaMaterialPrincipal;
    private double telaPorcentajeUso;
    private String talla;
    private String marcaNombre;
    private String marcaPais;

    public Ropa(String categoria, double precio) {
        super(categoria, precio);
    }

    public void personalizar(String color, String telaNombre, String telaMaterialPrincipal, double telaPorcentajeUso,
                             String talla, String marcaNombre, String marcaPais) {
        this.color = color;
        this.telaNombre = telaNombre;
        this.telaMaterialPrincipal = telaMaterialPrincipal;
        this.telaPorcentajeUso = telaPorcentajeUso;
        this.talla = talla;
        this.marcaNombre = marcaNombre;
        this.marcaPais = marcaPais;
    }

    @Override
    public ProductoBase clonar() {
        Ropa clon = new Ropa(this.categoria, this.precio);
        clon.personalizar(this.color, this.telaNombre, this.telaMaterialPrincipal, this.telaPorcentajeUso, this.talla,
                this.marcaNombre, this.marcaPais);
        return clon;
    }

    @Override
    public String mostrarInformacion() {
        return "Categoria: " + categoria + ", Precio: " + precio + ", Color: " + color +
                ", Tela: " + telaNombre + " (" + telaMaterialPrincipal + ", " + telaPorcentajeUso + "%)" +
                ", Talla: " + talla + ", Marca: " + marcaNombre + " (" + marcaPais + ")";
    }
}
