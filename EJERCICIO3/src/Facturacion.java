import java.util.Scanner;

public class Facturacion {
    private static final String[][] articulos = {
            {"101", "Leche", "25"},
            {"102", "Gaseosa", "30"},
            {"103", "Fideos", "15"},
            {"104", "Arroz", "28"},
            {"105", "Vino", "120"},
            {"106", "Manteca", "20"},
            {"107", "Lavandina", "18"},
            {"108", "Detergente", "46"},
            {"109", "Jabon en Polvo", "96"},
            {"110", "Galletas", "60"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Factura factura = new Factura();

        // Solicitar datos de la factura
        System.out.print("Ingrese la fecha de la factura: ");
        factura.setFechaFactura(scanner.nextLine());

        int numeroFactura;
        do {
            System.out.print("Ingrese el número de factura (mayor a 0): ");
            numeroFactura = scanner.nextInt();
        } while (numeroFactura <= 0);
        factura.setNumeroFactura(numeroFactura);

        scanner.nextLine(); // Limpiar buffer
        String cliente;
        do {
            System.out.print("Ingrese el nombre del cliente (no vacío): ");
            cliente = scanner.nextLine();
        } while (cliente.trim().isEmpty());
        factura.setCliente(cliente);

        // Cargar artículos
        while (true) {
            System.out.print("Ingrese el código del artículo (o -1 para finalizar): ");
            String codigo = scanner.nextLine();

            if (codigo.equals("-1")) {
                break;
            }

            boolean encontrado = false;
            for (String[] articulo : articulos) {
                if (articulo[0].equals(codigo)) {
                    encontrado = true;

                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    double precioUnitario = Double.parseDouble(articulo[2]);
                    double descuento = cantidad > 5 ? precioUnitario * 0.1 : 0;
                    double subtotal = (precioUnitario - descuento) * cantidad;

                    DetalleFactura detalle = new DetalleFactura(
                            Integer.parseInt(articulo[0]),
                            articulo[1],
                            cantidad,
                            precioUnitario,
                            descuento,
                            subtotal
                    );

                    factura.agregarDetalle(detalle);
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("El código ingresado no existe, intente nuevamente.");
            }
        }

        // Calcular monto total
        factura.calcularMontoTotal();

        // Mostrar factura
        System.out.println("\nFACTURA");
        System.out.println("Fecha: " + factura.getFechaFactura());
        System.out.println("Número: " + factura.getNumeroFactura());
        System.out.println("Cliente: " + factura.getCliente());
        System.out.println("Código Artículo Nombre Cantidad Precio Descuento Subtotal");
        for (DetalleFactura detalle : factura.getDetallesFactura()) {
            System.out.println(detalle);
        }
        System.out.println("Total: " + factura.getTotalCalculadoFactura());
    }
}
