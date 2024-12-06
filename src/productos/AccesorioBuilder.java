package productos;

import java.util.Scanner;

public class AccesorioBuilder extends ProductoBuilder {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void personalizar() {
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

        ((Accesorio) producto).personalizar(diseñadorNombre, diseñadorApellido, fechaElaboracion, materialNombre, materialTipo);
    }
}

