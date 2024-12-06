package productos;

public class Accesorio extends ProductoBase {
    private String diseñadorNombre;
    private String diseñadorApellido;
    private String fechaElaboracion;
    private String materialNombre;
    private String materialTipo;

    public Accesorio(String categoria, double precio) {
        super(categoria, precio);
    }

    public void personalizar(String diseñadorNombre, String diseñadorApellido, String fechaElaboracion,
                             String materialNombre, String materialTipo) {
        this.diseñadorNombre = diseñadorNombre;
        this.diseñadorApellido = diseñadorApellido;
        this.fechaElaboracion = fechaElaboracion;
        this.materialNombre = materialNombre;
        this.materialTipo = materialTipo;
    }

    @Override
    public ProductoBase clonar() {
        Accesorio clon = new Accesorio(this.categoria, this.precio);
        clon.personalizar(this.diseñadorNombre, this.diseñadorApellido, this.fechaElaboracion, this.materialNombre,
                this.materialTipo);
        return clon;
    }

    @Override
    public String mostrarInformacion() {
        return "Categoria: " + categoria + ", Precio: " + precio + ", Diseñador: " + diseñadorNombre + " " +
                diseñadorApellido + ", Fecha Elaboración: " + fechaElaboracion +
                ", Material: " + materialNombre + " (" + materialTipo + ")";
    }
}

