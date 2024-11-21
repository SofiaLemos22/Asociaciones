import java.util.ArrayList;
import java.util.Scanner;

public class MenuRestaurante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Plato> platosMenu = new ArrayList<>();

        System.out.println("Ingrese la cantidad de platos que desea agregar al menú:");
        int cantidadPlatos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        for (int i = 0; i < cantidadPlatos; i++) {
            System.out.println("Ingrese el nombre del plato:");
            String nombrePlato = scanner.nextLine();

            System.out.println("Ingrese el precio del plato:");
            double precioPlato = scanner.nextDouble();

            System.out.println("¿Es una bebida? (true/false):");
            boolean esBebida = scanner.nextBoolean();
            scanner.nextLine(); // Consumir el salto de línea

            Plato plato = new Plato(nombrePlato, precioPlato, esBebida);

            if (!esBebida) {
                System.out.println("Ingrese la cantidad de ingredientes para este plato:");
                int cantidadIngredientes = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                for (int j = 0; j < cantidadIngredientes; j++) {
                    System.out.println("Ingrese el nombre del ingrediente:");
                    String nombreIngrediente = scanner.nextLine();

                    System.out.println("Ingrese la cantidad del ingrediente:");
                    double cantidadIngrediente = scanner.nextDouble();

                    System.out.println("Ingrese la unidad de medida del ingrediente:");
                    scanner.nextLine(); // Consumir el salto de línea
                    String unidadMedida = scanner.nextLine();

                    Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidadIngrediente, unidadMedida);
                    plato.agregarIngrediente(ingrediente);
                }

                // Validar que al menos tenga un ingrediente
                if (plato.getIngredientes().isEmpty()) {
                    System.out.println("Error: El plato debe tener al menos un ingrediente.");
                    i--; // Repetir la carga del plato
                    continue;
                }
            }

            platosMenu.add(plato);
        }

        // Mostrar el menú
        System.out.println("\nMENÚ");
        for (Plato plato : platosMenu) {
            System.out.println(plato);
        }

        scanner.close();
    }
}



