package plataformaformacion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Plataforma app = new Plataforma();
        int opcion = 0;

        do {
            try {
                System.out.println("\n1. Crear Usuario | 2. Crear Contenido | 3. Ver Contenido | 4. Estadísticas | 0. Salir");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("ID, Nombre y Tipo (1:Gratis, 2:Mensual, 3:Anual):");
                        String id = sc.nextLine();
                        String nom = sc.nextLine();
                        int tipo = Integer.parseInt(sc.nextLine());
                        if(tipo == 1) app.registrarUsuario(new UsuarioGratuito(id, nom));
                        else if(tipo == 2) app.registrarUsuario(new UsuarioMensual(id, nom));
                        else app.registrarUsuario(new UsuarioAnual(id, nom));
                        break;
                        
                    case 3:
                        System.out.println("ID Usuario, Título Contenido, Minutos vistos:");
                        app.registrarVisualizacion(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
                        break;
                        
                    case 4:
                        app.mostrarEstadisticas();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error en la entrada de datos.");
            }
        } while (opcion != 0);
        sc.close();
    }
}