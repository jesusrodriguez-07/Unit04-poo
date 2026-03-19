package crud3;

import java.util.Scanner;

public class GestionPizzeria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pizzeria miPizzeria = new Pizzeria();
        int opcion;

        do {
            System.out.println("\n--- PIZZERÍA ---");
            System.out.println("1. Listado de pizzas");
            System.out.println("2. Nuevo pedido");
            System.out.println("3. Pizza servida");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    miPizzeria.mostrarListado();
                    break;

                case 2:
                    System.out.print("Tamaño (Mediana/Familiar): ");
                    String tam = sc.nextLine();
                    System.out.print("Tipo (Margarita/Cuatro Quesos/Funghi): ");
                    String tipo = sc.nextLine();
                    miPizzeria.nuevoPedido(new Pizza(tam, tipo));
                    System.out.println("Pedido registrado.");
                    break;

                case 3:
                    miPizzeria.mostrarListado();
                    System.out.print("¿Qué número de pizza quieres servir?: ");
                    int num = sc.nextInt() - 1; // Restamos 1 porque el ArrayList empieza en 0
                    
                    Pizza p = miPizzeria.getPizza(num);
                    if (p != null) {
                        p.servir();
                        System.out.println("¡Pizza servida!");
                    } else {
                        System.out.println("Número de pedido no válido.");
                    }
                    break;
            }
        } while (opcion != 4);
        
        System.out.println("Cerrando caja...");
        sc.close();
    }
}