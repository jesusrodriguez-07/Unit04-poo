package fatima;

import java.util.Scanner;

public class HundirLaFlota {

    // --- CONSTANTES: Para que el profe vea que soy ordenado ---
    // Si quiero cambiar el tamaño del mapa, solo toco aquí
    static final int TAMANO = 10;
    
    // NÚMEROS MÁGICOS (Lo que guarda la matriz)
    static final int AGUA = 0;
    static final int BARCO = 1;  
    static final int TOCADO = 2; 
    static final int FALLO = -1; 

    // DIBUJOS (Uso 2 caracteres para que la tabla no se tuerza)
    static final String PINTAR_AGUA = "~ ";
    static final String PINTAR_BARCO = "[]"; // Solo sale al final o con trucos
    static final String PINTAR_TOCADO = "X ";
    static final String PINTAR_FALLO = "o ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Creo el tablero vacio (todo ceros)
        int[][] tablero = new int[TAMANO][TAMANO];
        
        System.out.println("--- EXAMEN DE PROGRAMACIÓN: HUNDIR LA FLOTA ---");
        
        // 1. COLOCACIÓN DE BARCOS
        // Voy sumando el tamaño de cada barco para saber cuántos aciertos necesito para ganar
        int vidasTotales = 0;
        vidasTotales += colocarBarco(tablero, 4); // El Portaaviones
        vidasTotales += colocarBarco(tablero, 3); // Acorazado
        vidasTotales += colocarBarco(tablero, 3); // Submarino grande
        vidasTotales += colocarBarco(tablero, 2); // Destructor
        vidasTotales += colocarBarco(tablero, 2); // Lancha
        vidasTotales += colocarBarco(tablero, 2); // Otra lancha
        
        int aciertos = 0;
        int intentos = 0;

        // 2. BUCLE DEL JUEGO (Mientras me queden barcos por hundir...)
        while (aciertos < vidasTotales) {
            
            System.out.println("\n--- TURNO " + (intentos + 1) + " | TE FALTAN: " + (vidasTotales - aciertos) + " ---");
            
            // Muestro el tablero ocultando los barcos (false) para no hacer trampas
            mostrarTablero(tablero, false); 

            // 3. PEDIR DATOS AL USUARIO
            // Uso una función auxiliar para que el main no se llene de basura
            int[] coordenadas = pedirCoordenadas(sc);
            int fila = coordenadas[0];
            int col = coordenadas[1];

            // 4. COMPROBAR EL TIRO
            int casilla = tablero[fila][col];

            if (casilla == BARCO) {
                System.out.println(">>> ¡BOOM! 💥 Le has dado.");
                tablero[fila][col] = TOCADO; // Marco la casilla como reventada
                aciertos++; // Sumo un punto
            } 
            else if (casilla == AGUA) {
                System.out.println(">>> Agua... 💧 has fallado.");
                tablero[fila][col] = FALLO; // Marco el fallo para no repetir
            } 
            else {
                // Si entra aquí es que era TOCADO (2) o FALLO (-1)
                System.out.println(">>> ¡Ojo! Ya habías disparado aquí. Pierdes turno.");
            }
            
            intentos++; // Sumo turno pase lo que pase
        }

        // FIN DEL JUEGO
        System.out.println("\n🎉 ¡ENHORABUENA! Has hundido toda la flota en " + intentos + " intentos.");
        mostrarTablero(tablero, true); // Ahora sí muestro dónde estaban los barcos (true)
        sc.close();
    }

    // ================================================================
    //                     MIS FUNCIONES
    // ================================================================

    /**
     * Función que intenta poner un barco aleatorio hasta que lo consigue.
     * Devuelve el tamaño del barco para sumarlo a las vidas totales.
     */
    public static int colocarBarco(int[][] t, int tamanoBarco) {
        boolean colocado = false;
        
        // Bucle infinito hasta que encuentre un hueco válido
        while (!colocado) {
            // Elijo coordenadas al azar
            int f = (int) (Math.random() * TAMANO);
            int c = (int) (Math.random() * TAMANO);
            
            // Decido si va tumbado (horizontal) o de pie (vertical)
            // Math.random da de 0.0 a 1.0, así que < 0.5 es un 50% de probabilidad
            boolean horizontal = Math.random() < 0.5; 

            boolean cabe = true;

            // --- COMPROBACIONES DE SEGURIDAD ---
            if (horizontal) {
                // 1. Miro si se sale del mapa por la derecha
                if (c + tamanoBarco > TAMANO) {
                    cabe = false;
                } else {
                    // 2. Miro si choca con otro barco (recorro las casillas que ocuparía)
                    for (int i = 0; i < tamanoBarco; i++) {
                        if (t[f][c + i] != AGUA) { // Si no es agua, hay barco -> Error
                            cabe = false;
                        }
                    }
                }
            } else { // VERTICAL
                // 1. Miro si se sale del mapa por abajo
                if (f + tamanoBarco > TAMANO) {
                    cabe = false;
                } else {
                    // 2. Miro si choca
                    for (int i = 0; i < tamanoBarco; i++) {
                        if (t[f + i][c] != AGUA) {
                            cabe = false;
                        }
                    }
                }
            }

            // --- SI CABE, LO PINTO ---
            if (cabe) {
                for (int i = 0; i < tamanoBarco; i++) {
                    if (horizontal) {
                        t[f][c + i] = BARCO;
                    } else {
                        t[f + i][c] = BARCO;
                    }
                }
                colocado = true; // ¡Conseguido! Salimos del while
            }
        }
        return tamanoBarco;
    }

    /**
     * Pinta el tablero bonito. 
     * Si modoTruco es true, veo los barcos. Si es false, veo agua.
     */
    public static void mostrarTablero(int[][] t, boolean modoTruco) {
        // Cabecera de números
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
        System.out.println("   -------------------");
        
        char letra = 'A'; // Empezamos por la A
        
        for (int i = 0; i < t.length; i++) {
            System.out.print(letra + "| "); // Pinto la letra y la barra
            
            for (int j = 0; j < t[0].length; j++) {
                int valor = t[i][j];
                
                // Decido qué símbolo imprimir
                if (valor == TOCADO) {
                    System.out.print(PINTAR_TOCADO);
                } 
                else if (valor == FALLO) {
                    System.out.print(PINTAR_FALLO);
                } 
                else if (valor == BARCO) {
                    // Si estoy en modo truco (o fin de juego) lo enseño, si no, pinto agua
                    if (modoTruco) {
                        System.out.print(PINTAR_BARCO);
                    } else {
                        System.out.print(PINTAR_AGUA);
                    }
                } 
                else { // Es AGUA (0)
                    System.out.print(PINTAR_AGUA);
                }
            }
            System.out.println("|" + letra); // Cierro la fila
            letra++; // Paso a la siguiente letra (A -> B -> C...)
        }
    }

    /**
     * Se encarga de pedir el texto (A5) y convertirlo a números (0, 5).
     * Tiene protecciones para que el programa no falle si escriben mal.
     */
    public static int[] pedirCoordenadas(Scanner sc) {
        int[] resultado = new int[2]; // Aquí guardaré [fila, columna]
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Dispara (Letra y Número, ej: A5): ");
                // Limpio espacios y paso a mayúsculas para evitar líos
                String entrada = sc.nextLine().trim().toUpperCase();

                // Si escribe menos de 2 letras (ej: "A") está mal
                if (entrada.length() < 2) {
                    System.out.println("Error: Escribe al menos una letra y un número.");
                    continue; // Vuelve al principio del while
                }

                char letra = entrada.charAt(0);
                char numero = entrada.charAt(1);

                // --- TRUCO DEL ASCII ---
                // 'A' vale 65. Si resto 'A' - 'A' me da 0. 'B' - 'A' da 1.
                int fila = letra - 'A';
                
                // Convierto el carácter '5' en el número 5
                int col = Character.getNumericValue(numero);

                // Compruebo que esté dentro del tablero (0 al 9)
                if (fila >= 0 && fila < TAMANO && col >= 0 && col < TAMANO) {
                    resultado[0] = fila;
                    resultado[1] = col;
                    valido = true; // Todo ok, salimos
                } else {
                    System.out.println("Error: Te has salido del mapa (A-J, 0-9).");
                }

            } catch (Exception e) {
                // Si pasa algo raro (excepción), capturo el error para que no se cierre el programa
                System.out.println("Error: Formato no válido. Inténtalo de nuevo.");
            }
        }
        return resultado;
    }
}