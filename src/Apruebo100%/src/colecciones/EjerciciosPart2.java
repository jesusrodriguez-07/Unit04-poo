package colecciones;

import java.util.*;

public class EjerciciosPart2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ejercicio;

        do {
            System.out.println("\n--- MENÚ COLECCIONES PARTE 2 ---");
            System.out.println("1. Mezclar lista (1-10)");
            System.out.println("2. 10 distintos en orden inserción (LinkedHashSet)");
            System.out.println("3. Frecuencia de letras (TreeMap)");
            System.out.println("4. Menú de nombres (ArrayList)");
            System.out.println("5. Gestión de Series TV (HashMap)");
            System.out.println("6. Libreta de direcciones (Map de Listas)");
            System.out.println("7. Clasificar palabras por longitud (Map de Sets)");
            System.out.println("8. Lista de tareas por categoría (Map de Listas)");
            System.out.println("0. Salir");
            System.out.print("Selecciona ejercicio: ");
            
            ejercicio = Integer.parseInt(sc.nextLine());

            switch (ejercicio) {
                case 1: ej1(); break;
                case 2: ej2(); break;
                case 3: ej3(); break;
                case 4: ej4(sc); break;
                case 5: ej5(sc); break;
                case 6: ej6(sc); break;
                case 7: ej7(sc); break;
                case 8: ej8(sc); break;
                case 0: System.out.println("¡A por el sobresaliente!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (ejercicio != 0);
    }

    // EJERCICIO 1: Shuffle (Mezclar)
    public static void ej1() {
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 10; i++) numeros.add(i);
        
        System.out.println("Original: " + numeros);
        Collections.shuffle(numeros); // Método mágico para mezclar
        System.out.println("Mezclada: " + numeros);
    }

    // EJERCICIO 2: Únicos + Orden de Inserción
    // LinkedHashSet es la clave: evita duplicados y NO desordena como el HashSet normal.
    public static void ej2() {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        Random rnd = new Random();
        while (set.size() < 10) {
            set.add(rnd.nextInt(20) + 1);
        }
        System.out.println("10 únicos en orden de llegada: " + set);
    }

    // EJERCICIO 3: Frecuencia de letras
    // Usamos TreeMap para que el resultado salga ordenado alfabéticamente (A, B, C...)
    public static void ej3() {
        String texto = "En un agujero en el suelo, vivia un hobbit. No un agujero humedo, sucio, repugnante, con restos de gusanos y olor a fango, ni tampoco un agujero, seco, desnudo y arenoso, sin nada en que sentarse o que comer: era un agujero-hobbit, y eso significa comodidad";
        TreeMap<Character, Integer> frecuencias = new TreeMap<>();

        for (char c : texto.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) { // Pista del ejercicio
                frecuencias.put(c, frecuencias.getOrDefault(c, 0) + 1);
            }
        }
        System.out.println("Conteo de letras: " + frecuencias);
    }

    // EJERCICIO 4: Menú de nombres
    public static void ej4(Scanner sc) {
        ArrayList<String> nombres = new ArrayList<>();
        int op;
        do {
            System.out.println("\n1. Añadir | 2. Eliminar | 3. Ordenar | 4. Buscar | 5. Volver");
            op = Integer.parseInt(sc.nextLine());
            if (op == 1) {
                System.out.print("Nombre: "); nombres.add(sc.nextLine());
            } else if (op == 2) {
                System.out.print("Nombre a borrar: "); nombres.remove(sc.nextLine());
            } else if (op == 3) {
                Collections.sort(nombres);
                System.out.println("Ordenada: " + nombres);
            } else if (op == 4) {
                System.out.print("Buscar: ");
                System.out.println(nombres.contains(sc.nextLine()) ? "Está en la lista" : "No está");
            }
        } while (op != 5);
    }

    // EJERCICIO 5: Gestión de Series (Rating)
    public static void ej5(Scanner sc) {
        HashMap<String, Double> series = new HashMap<>();
        // Lógica de menú similar a la anterior...
        System.out.print("Nombre serie: "); String nombre = sc.nextLine();
        System.out.print("Valoración: "); double val = Double.parseDouble(sc.nextLine());
        series.put(nombre, val);
        System.out.println("Serie guardada. Valoración de " + nombre + ": " + series.get(nombre));
    }

    // EJERCICIO 6: Libreta de Direcciones (MAPA DE LISTAS)
    // Concepto clave: Una persona (String) tiene MUCHOS teléfonos (ArrayList)
    public static void ej6(Scanner sc) {
        HashMap<String, ArrayList<String>> libreta = new HashMap<>();
        
        System.out.println("1. Añadir Persona | 2. Añadir Teléfono | 3. Mostrar");
        int op = Integer.parseInt(sc.nextLine());
        
        if (op == 1) {
            System.out.print("Nombre: "); String n = sc.nextLine();
            libreta.putIfAbsent(n, new ArrayList<>()); // Creamos la lista vacía para esa persona
        } else if (op == 2) {
            System.out.print("¿A quién?: "); String n = sc.nextLine();
            if (libreta.containsKey(n)) {
                System.out.print("Teléfono: ");
                libreta.get(n).add(sc.nextLine()); // Accedemos a la lista y añadimos
            }
        } else if (op == 3) {
            System.out.println(libreta);
        }
    }

    // EJERCICIO 7: Clasificación por longitud
    // Clave: Longitud (Integer) -> Valor: Conjunto de palabras (Set)
 // Ahora sí recibe el Scanner para ser interactivo
    public static void ej7(Scanner sc) {
        // Clave: Longitud (Integer) -> Valor: Conjunto de palabras (TreeSet para que salgan ordenadas A-Z)
        TreeMap<Integer, TreeSet<String>> clasificador = new TreeMap<>();

        System.out.println("Introduce palabras para clasificar (escribe 'fin' para terminar):");
        String palabra;

        while (!(palabra = sc.nextLine()).equalsIgnoreCase("fin")) {
            int longitud = palabra.length();

            // PASO 1: Si es la primera vez que vemos una palabra de esta longitud,
            // creamos el "saquito" (TreeSet) para guardarlas.
            clasificador.putIfAbsent(longitud, new TreeSet<>());

            // PASO 2: Metemos la palabra en el saquito correspondiente a su longitud.
            clasificador.get(longitud).add(palabra);
        }

        // PASO 3: Mostrar el resultado
        System.out.println("\n--- CLASIFICACIÓN POR LONGITUD ---");
        for (int lon : clasificador.keySet()) {
            System.out.println("Longitud " + lon + ": " + clasificador.get(lon));
        }
    }

    // EJERCICIO 8: Lista de tareas por categoría
    public static void ej8(Scanner sc) {
        HashMap<String, ArrayList<String>> tareas = new HashMap<>();
        // Similar a la libreta de direcciones:
        System.out.print("Categoría (Trabajo/Personal): "); String cat = sc.nextLine();
        System.out.print("Tarea: "); String tarea = sc.nextLine();
        
        tareas.putIfAbsent(cat, new ArrayList<>());
        tareas.get(cat).add(tarea);
        
        System.out.println("Tareas en " + cat + ": " + tareas.get(cat));
    }
}