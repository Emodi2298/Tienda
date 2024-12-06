import Pedidos.Pedido;
import productos.*;
import Pedidos.AdministradorDePedidos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdministradorDePedidos adminPedidos = AdministradorDePedidos.getInstance();

        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Crear Producto Básico");
            System.out.println("2. Personalizar Producto");
            System.out.println("3. Clonar Producto");
            System.out.println("4. Mostrar Pedidos");
            System.out.println("5. Actualizar Estado de Pedido");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Tipo de producto (ropa/accesorio/calzado): ");
                    String tipo = scanner.nextLine().toLowerCase();
                    try {
                        ProductoBase producto = FabricaDeProductos.crearProducto(tipo, 100.0);
                        adminPedidos.agregarPedido(producto);
                        System.out.println("Producto creado y personalizado exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2":
                    adminPedidos.mostrarPedidos();
                    System.out.print("Selecciona el ID del pedido para personalizar: ");
                    try {
                        int idPersonalizar = Integer.parseInt(scanner.nextLine());
                        Pedido pedidoExistente = adminPedidos.getPedidos().stream()
                                .filter(p -> p.getId() == idPersonalizar)
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException("ID inválido"));

                        ProductoBase producto = pedidoExistente.getProducto();
                        System.out.println("Personalizando el producto...");

                        // Detecta el tipo de producto y permite personalizar atributos
                        if (producto instanceof Ropa) {
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
                        } else if (producto instanceof Accesorio) {
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
                        } else if (producto instanceof Calzado) {
                            System.out.print("Capellada (sintético/textil): ");
                            String capellada = scanner.nextLine();

                            System.out.print("Suela (antideslizante/con tacón/caucho): ");
                            String suela = scanner.nextLine();

                            System.out.print("Cierre (broche/corredera/cordón): ");
                            String cierre = scanner.nextLine();

                            ((Calzado) producto).personalizar(capellada, suela, cierre);
                        }

                        System.out.println("Producto personalizado exitosamente.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "3":
                    adminPedidos.mostrarPedidos();
                    System.out.print("Selecciona el ID del pedido a clonar: ");
                    int idClonar = Integer.parseInt(scanner.nextLine());
                    ProductoBase clon = adminPedidos.getPedidos().stream()
                            .filter(p -> p.getId() == idClonar)
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("ID inválido"))
                            .getProducto()
                            .clonar();
                    adminPedidos.agregarPedido(clon);
                    System.out.println("Producto clonado exitosamente.");
                    break;

                case "4":
                    adminPedidos.mostrarPedidos();
                    break;

                case "5":
                    adminPedidos.mostrarPedidos();
                    System.out.print("Selecciona el ID del pedido para actualizar estado: ");
                    int idEstado = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nuevo estado (en proceso/procesado/enviado/entregado): ");
                    String nuevoEstado = scanner.nextLine();
                    adminPedidos.actualizarEstadoPedido(idEstado, nuevoEstado);
                    System.out.println("Estado actualizado.");
                    break;

                case "6":
                    System.out.println("¡Hasta luego!");
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}


