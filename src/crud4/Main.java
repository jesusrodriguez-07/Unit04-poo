package crud4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Coleccion miColeccion = new Coleccion();
        int opcion;

        do {
            System.out.println("\nCOLECCIÓN DE DISCOS\n===================");
            System.out.println("1. Listado.\n2. Nuevo Disco.\n3. Borrar.\n4. Salir.");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer siempre

            switch (opcion) {
                case 1:
                    miColeccion.listado();
                    break;
                case 2:
                    System.out.print("Código: "); String cod = sc.nextLine();
                    System.out.print("Autor: "); String aut = sc.nextLine();
                    System.out.print("Título: "); String tit = sc.nextLine();
                    System.out.print("Duración (min): "); int dur = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Género (Rock/Pop/Jazz/Blues): "); String gen = sc.nextLine();
                    
                    miColeccion.nuevoDisco(new Disco(cod, aut, tit, dur, gen));
                    break;
                case 3:
                    System.out.print("Introduce el código del disco a borrar: ");
                    String codBorrar = sc.nextLine();
                    if (miColeccion.borrarDisco(codBorrar)) {
                        System.out.println("Disco eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró ningún disco con ese código.");
                    }
                    break;
            }
        } while (opcion != 4);
        
        System.out.println("Programa finalizado.");
    }
}