package productos;

import java.util.Scanner;

public class FabricaDeProductos {
    private static final Scanner scanner = new Scanner(System.in);

    public static ProductoBase crearProducto(String tipo, double precio) {
        switch (tipo.toLowerCase()) {
            case "ropa":
                return configurarRopa();
            case "accesorio":
                return configurarAccesorio();
            case "calzado":
                return configurarCalzado();
            default:
                throw new IllegalArgumentException("Tipo de producto desconocido.");
        }
    }

    private static Ropa configurarRopa() {
        System.out.println("Selecciona un tipo de ropa: (1) Camisetas, (2) Sudaderas, (3) Gorras");
        String tipoRopa = scanner.nextLine();
        String subcategoria;
        switch (tipoRopa) {
            case "1":
                subcategoria = "Camisetas";
                break;
            case "2":
                subcategoria = "Sudaderas";
                break;
            case "3":
                subcategoria = "Gorras";
                break;
            default:
                throw new IllegalArgumentException("Opción inválida.");
        }

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Tela (nombre): ");
        String telaNombre = scanner.nextLine();

        System.out.print("Tela (material principal): ");
        String telaMaterialPrincipal = scanner.nextLine();

        System.out.print("Tela (% de uso): ");
        double telaPorcentajeUso = Double.parseDouble(scanner.nextLine());

        System.out.print("Talla (S/M/L/XL): ");
        String talla = scanner.nextLine();

        System.out.print("Marca (nombre): ");
        String marcaNombre = scanner.nextLine();

        System.out.print("Marca (país): ");
        String marcaPais = scanner.nextLine();

        Ropa ropa = new Ropa(subcategoria, 100.0);
        ropa.personalizar(color, telaNombre, telaMaterialPrincipal, telaPorcentajeUso, talla, marcaNombre, marcaPais);
        return ropa;
    }

    private static Accesorio configurarAccesorio() {
        System.out.println("Selecciona un tipo de accesorio: (1) Cadenas, (2) Pulseras, (3) Anillos");
        String tipoAccesorio = scanner.nextLine();
        String subcategoria;
        switch (tipoAccesorio) {
            case "1":
                subcategoria = "Cadenas";
                break;
            case "2":
                subcategoria = "Pulseras";
                break;
            case "3":
                subcategoria = "Anillos";
                break;
            default:
                throw new IllegalArgumentException("Opción inválida.");
        }

        System.out.print("Diseñador (nombre): ");
        String diseñadorNombre = scanner.nextLine();

        System.out.print("Diseñador (apellido): ");
        String diseñadorApellido = scanner.nextLine();

        System.out.print("Fecha de elaboración: ");
        String fechaElaboracion = scanner.nextLine();

        System.out.print("Material (nombre): ");
        String materialNombre = scanner.nextLine();

        System.out.print("Material (tipo: natural/sintético/reciclado): ");
        String materialTipo = scanner.nextLine();

        Accesorio accesorio = new Accesorio(subcategoria, 50.0);
        accesorio.personalizar(diseñadorNombre, diseñadorApellido, fechaElaboracion, materialNombre, materialTipo);
        return accesorio;
    }

    private static Calzado configurarCalzado() {
        System.out.println("Selecciona un tipo de calzado: (1) Tenis, (2) Casual, (3) Mocasines");
        String tipoCalzado = scanner.nextLine();
        String subcategoria;
        switch (tipoCalzado) {
            case "1":
                subcategoria = "Tenis";
                break;
            case "2":
                subcategoria = "Casual";
                break;
            case "3":
                subcategoria = "Mocasines";
                break;
            default:
                throw new IllegalArgumentException("Opción inválida.");
        }

        System.out.print("Capellada (sintético/textil): ");
        String capellada = scanner.nextLine();

        System.out.print("Suela (antideslizante/con tacón/caucho): ");
        String suela = scanner.nextLine();

        System.out.print("Cierre (broche/corredera/cordón): ");
        String cierre = scanner.nextLine();

        Calzado calzado = new Calzado(subcategoria, 150.0);
        calzado.personalizar(capellada, suela, cierre);
        return calzado;
    }
}


