import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CargaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();

        System.out.println("Ingrese la cantidad de alumnos:");
        int cantidadAlumnos = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Ingrese el nombre completo del alumno:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el legajo del alumno:");
            long legajo = scanner.nextLong();
            scanner.nextLine(); // Consumir salto de línea

            Alumno alumno = new Alumno(nombre, legajo);

            System.out.println("Ingrese la cantidad de notas para el alumno:");
            int cantidadNotas = scanner.nextInt();

            for (int j = 0; j < cantidadNotas; j++) {
                System.out.println("Ingrese la cátedra:");
                scanner.nextLine(); // Consumir salto de línea
                String catedra = scanner.nextLine();

                System.out.println("Ingrese la nota del examen:");
                double notaExamen = scanner.nextDouble();

                alumno.agregarNota(new Nota(catedra, notaExamen));
            }

            alumnos.add(alumno);
        }

        // Mostrar información de los alumnos y sus promedios
        System.out.println("\nInformación de los alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNombreCompleto() +
                    " (Legajo: " + alumno.getLegajo() + ")");
            System.out.println("Promedio de notas: " + alumno.calcularPromedio());
        }

        scanner.close();

    }
}