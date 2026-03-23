package colecciones;

import java.util.*;

public class EjerciciosPart1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ejercicio;

        do {
            System.out.println("\n--- MENÚ DE EJERCICIOS DE COLECCIONES ---");
            System.out.println("1. Índices de pares (ArrayList)");
            System.out.println("2. Estadísticas aleatorias (ArrayList)");
            System.out.println("3. 30 números ordenados (ArrayList + Sort)");
            System.out.println("4. 20 distintos y ordenados (TreeSet)");
            System.out.println("5. Nombres orden inserción (LinkedHashSet)");
            System.out.println("6. Nombres orden alfabético (TreeSet)");
            System.out.println("7. Diccionario (TreeMap)");
            System.out.println("8. Login Restringido (HashMap)");
            System.out.println("9. Frecuencia Euromillón (TreeMap)");
            System.out.println("10. Gestión Productos (HashMap)");
            System.out.println("0. Salir");
            System.out.print("Elige una misión: ");
            
            ejercicio = Integer.parseInt(sc.nextLine());

            switch (ejercicio) {
                case 1: ej1(sc); break;
                case 2: ej2(); break;
                case 3: ej3(); break;
                case 4: ej4(); break;
                case 5: ej5(sc); break;
                case 6: ej6(sc); break;
                case 7: ej7(sc); break;
                case 8: ej8(sc); break;
                case 9: ej9(sc); break;
                case 10: ej10(sc); break;
                case 0: System.out.println("¡Suerte en el examen!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (ejercicio != 0);
    }

    // EJERCICIO 1: Índices de pares
    // Usamos ArrayList porque necesitamos manejar posiciones (índices).
    public static void ej1(Scanner sc) {
        ArrayList<Integer> lista = new ArrayList<>();
        System.out.println("Introduce números (negativo para parar):");
        int n;
        while ((n = Integer.parseInt(sc.nextLine())) >= 0) {
            lista.add(n);
        }
        System.out.print("Índices con valor par: ");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) % 2 == 0) System.out.print(i + " ");
        }
        System.out.println();
    }

    // EJERCICIO 2: Estadísticas
    public static void ej2() {
        Random rnd = new Random();
        int tam = rnd.nextInt(6) + 5; // Entre 5 y 10
        ArrayList<Integer> nums = new ArrayList<>();
        int suma = 0;
        for (int i = 0; i < tam; i++) {
            int n = rnd.nextInt(101);
            nums.add(n);
            suma += n;
        }
        System.out.println("Lista: " + nums);
        System.out.println("Suma: " + suma);
        System.out.println("Media: " + (double) suma / nums.size());
        System.out.println("Máximo: " + Collections.max(nums));
        System.out.println("Mínimo: " + Collections.min(nums));
    }

    // EJERCICIO 3: 30 números con repetidos ordenados
    // Usamos ArrayList y luego ordenamos, porque el Set borraría los repetidos.
    public static void ej3() {
        ArrayList<Integer> lista = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 30; i++) lista.add(rnd.nextInt(10) + 1);
        Collections.sort(lista);
        System.out.println("Ordenados: " + lista);
    }

    // EJERCICIO 4: 20 distintos y ordenados
    // TreeSet es perfecto: no admite repetidos y ordena solo.
    public static void ej4() {
        TreeSet<Integer> set = new TreeSet<>();
        Random rnd = new Random();
        while (set.size() < 20) set.add(rnd.nextInt(100));
        System.out.println("20 distintos ordenados: " + set);
    }

    // EJERCICIO 5: Nombres orden inserción sin repetir
    // LinkedHashSet: no repite y respeta quién llegó primero.
    public static void ej5(Scanner sc) {
        LinkedHashSet<String> nombres = new LinkedHashSet<>();
        String s;
        System.out.println("Introduce nombres ('fin' para acabar):");
        while (!(s = sc.nextLine()).equalsIgnoreCase("fin")) nombres.add(s);
        System.out.println("Nombres (orden inserción): " + nombres);
    }

    // EJERCICIO 6: Nombres orden alfabético sin repetir
    // TreeSet: no repite y ordena de la A a la Z.
    public static void ej6(Scanner sc) {
        TreeSet<String> nombres = new TreeSet<>();
        String s;
        System.out.println("Introduce nombres ('fin' para acabar):");
        while (!(s = sc.nextLine()).equalsIgnoreCase("fin")) nombres.add(s);
        System.out.println("Nombres (alfabético): " + nombres);
    }

    // EJERCICIO 7: Diccionario
    // TreeMap: Clave(Esp) -> Valor(Ing). Las claves se ordenan solas.
    public static void ej7(Scanner sc) {
        TreeMap<String, String> dicc = new TreeMap<>();
        // Pre-carga
        dicc.put("perro", "dog"); dicc.put("gato", "cat");
        System.out.println("1. Insertar | 2. Buscar");
        int op = Integer.parseInt(sc.nextLine());
        if (op == 1) {
            System.out.print("Español: "); String es = sc.nextLine();
            System.out.print("Inglés: "); String en = sc.nextLine();
            dicc.put(es, en);
        } else {
            System.out.print("Palabra a buscar: ");
            String busca = sc.nextLine();
            System.out.println("Traducción: " + dicc.getOrDefault(busca, "No encontrada"));
        }
    }

    // EJERCICIO 8: Login con 3 intentos
    // HashMap: Ideal para buscar rápido un usuario.
    public static void ej8(Scanner sc) {
        HashMap<String, String> usuarios = new HashMap<>();
        usuarios.put("admin", "1234"); // Usuario de prueba
        
        System.out.println("--- LOGIN ---");
        int intentos = 0;
        boolean acceso = false;
        while (intentos < 3 && !acceso) {
            System.out.print("Usuario: "); String u = sc.nextLine();
            System.out.print("Pass: "); String p = sc.nextLine();
            if (usuarios.containsKey(u) && usuarios.get(u).equals(p)) {
                acceso = true;
            } else {
                intentos++;
                System.out.println("Fallo. Intentos: " + intentos + "/3");
            }
        }
        System.out.println(acceso ? "Acceso concedido" : "Bloqueado");
    }

    // EJERCICIO 9: Euromillón (Frecuencia)
    // TreeMap: Guarda el Número -> Cuántas veces ha salido.
    public static void ej9(Scanner sc) {
        TreeMap<Integer, Integer> nums = new TreeMap<>();
        System.out.println("Introduce los 5 números del sorteo:");
        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(sc.nextLine());
            nums.put(n, nums.getOrDefault(n, 0) + 1);
        }
        System.out.println("Frecuencias actuales: " + nums);
    }

    // EJERCICIO 10: Productos
    // HashMap: Producto(Nombre) -> Precio.
    public static void ej10(Scanner sc) {
        HashMap<String, Double> stock = new HashMap<>();
        System.out.println("1. Alta | 2. Baja | 3. Listar");
        int op = Integer.parseInt(sc.nextLine());
        if (op == 1) {
            System.out.print("Nombre: "); String n = sc.nextLine();
            System.out.print("Precio: "); double p = Double.parseDouble(sc.nextLine());
            stock.put(n, p);
        } else if (op == 3) {
            for (String prod : stock.keySet()) {
                System.out.println(prod + ": " + stock.get(prod) + "€");
            }
        }
    }
}