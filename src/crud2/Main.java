package crud2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Almacen miAlmacen = new Almacen();
        int opcion;

        do {
            System.out.println("\nGESTISIMAL - Menú\n1. Listado\n2. Alta\n3. Baja\n4. Modificación\n5. Entrada\n6. Salida\n7. Salir");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 2: // Alta
                    System.out.print("Código: "); String cod = sc.nextLine();
                    System.out.print("Descripción: "); String desc = sc.nextLine();
                    System.out.print("Stock inicial: "); int st = sc.nextInt();
                    miAlmacen.alta(new Articulo(cod, desc, 10.0, 15.0, st));
                    break;

                case 5: // Entrada de mercancía
                    System.out.print("Código del artículo: ");
                    Articulo artEntrada = miAlmacen.buscar(sc.nextLine());
                    if (artEntrada != null) {
                        System.out.print("Cantidad a entrar: ");
                        artEntrada.incrementarStock(sc.nextInt());
                    } else {
                        System.out.println("Código no encontrado.");
                    }
                    break;

                case 6: // Salida de mercancía
                    System.out.print("Código del artículo: ");
                    Articulo artSalida = miAlmacen.buscar(sc.nextLine());
                    if (artSalida != null) {
                        System.out.print("Cantidad a sacar: ");
                        int cant = sc.nextInt();
                        if (!artSalida.decrementarStock(cant)) {
                            System.out.println("ERROR: No hay stock suficiente.");
                        }
                    } else {
                        System.out.println("Código no encontrado.");
                    }
                    break;
                
                case 1: miAlmacen.listado(); break;
                // ... el resto de casos (baja, mod) siguen la misma lógica de buscar y operar
            }
        } while (opcion != 7);
    }
}