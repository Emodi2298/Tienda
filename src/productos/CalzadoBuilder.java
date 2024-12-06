package productos;

import java.util.Scanner;

public class CalzadoBuilder extends ProductoBuilder {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void personalizar() {
        System.out.print("Capellada (sintético/textil): ");
        String capellada = scanner.nextLine();

        System.out.print("Suela (antideslizante/con tacón/caucho): ");
        String suela = scanner.nextLine();

        System.out.print("Cierre (broche/corredera/cordón): ");
        String cierre = scanner.nextLine();

        ((Calzado) producto).personalizar(capellada, suela, cierre);
    }
}
