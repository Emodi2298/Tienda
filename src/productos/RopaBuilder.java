package productos;

import java.util.Scanner;

public class RopaBuilder extends ProductoBuilder {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void personalizar() {
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

        ((Ropa) producto).personalizar(color, telaNombre, telaMaterialPrincipal, telaPorcentajeUso, talla, marcaNombre, marcaPais);
    }
}

