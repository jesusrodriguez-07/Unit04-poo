package biblioteca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblio = new Biblioteca();
        int op = 0;

        do {
            try {
                System.out.println("\n1. Alta Libro | 2. Alta Socio | 3. Préstamo | 4. Devolución | 5. Ver Disponibles | 0. Salir");
                op = Integer.parseInt(sc.nextLine());

                switch(op) {
                    case 1:
                        System.out.println("ISBN, Título, Ejemplares:");
                        biblio.altaLibro(new Libro(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
                        break;
                    case 3:
                        System.out.println("DNI Socio e ISBN Libro:");
                        System.out.println(biblio.realizarPrestamo(sc.nextLine(), sc.nextLine()));
                        break;
                    case 5:
                        biblio.mostrarDisponibles();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error de datos.");
            }
        } while (op != 0);
        sc.close();
    }
}