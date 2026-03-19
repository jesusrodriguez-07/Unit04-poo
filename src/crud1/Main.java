package crud1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionAlumnos gestor = new GestionAlumnos(); // Nuestra clase intermedia
        int opcion = 0;

        do {
            System.out.println("\nALUMNOS/AS\n===================");
            System.out.println("1. Listado.\n2. Nuevo Alumno.\n3. Modificar.\n4. Borrar.\n5. Salir.");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    gestor.listarAlumnos();
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    System.out.print("Nota: ");
                    double nota = sc.nextDouble();
                    gestor.añadirAlumno(new Alumno(nom, nota));
                    break;
                case 3:
                    System.out.print("Nombre del alumno a modificar: ");
                    String nomMod = sc.nextLine();
                    System.out.print("Nueva nota: ");
                    double nuevaNota = sc.nextDouble();
                    if (gestor.modificarNota(nomMod, nuevaNota)) {
                        System.out.println("Nota actualizada.");
                    } else {
                        System.out.println("Alumno no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nombre del alumno a borrar: ");
                    String nomBorrar = sc.nextLine();
                    if (gestor.borrarAlumno(nomBorrar)) {
                        System.out.println("Alumno eliminado.");
                    } else {
                        System.out.println("Alumno no encontrado.");
                    }
                    break;
            }
        } while (opcion != 5);
        System.out.println("¡Adiós!");
        sc.close();
    }
}