package plataformaformacion;

import java.util.*;

/**
 * Clase principal que gestiona la lógica de negocio de la plataforma.
 */
public class Plataforma {
    private HashMap<String, Usuario> usuarios = new HashMap<>();
    private ArrayList<Contenido> contenidos = new ArrayList<>();
    
    // Mapa para contar cuántas veces se ve cada contenido
    private HashMap<String, Integer> estadisticasContenido = new HashMap<>();
    // Mapa para contar minutos vistos por cada usuario
    private HashMap<String, Integer> actividadUsuarios = new HashMap<>();

    public void registrarUsuario(Usuario u) {
        if (!usuarios.containsKey(u.getId())) {
            usuarios.put(u.getId(), u);
        }
    }

    public void añadirContenido(Contenido c) {
        contenidos.add(c);
    }

    /**
     * Registra que un usuario ha visto un contenido.
     */
    public void registrarVisualizacion(String userId, String tituloContenido, int minutos) {
        if (usuarios.containsKey(userId)) {
            // Contar visualización del contenido
            estadisticasContenido.put(tituloContenido, estadisticasContenido.getOrDefault(tituloContenido, 0) + 1);
            // Contar actividad del usuario
            actividadUsuarios.put(userId, actividadUsuarios.getOrDefault(userId, 0) + minutos);
        }
    }

    public double calcularIngresosTotales() {
        double total = 0;
        for (Usuario u : usuarios.values()) {
            total += u.calcularIngresos();
        }
        return total;
    }

    public void listarUsuarios() {
        usuarios.values().forEach(System.out::println);
    }

    public void mostrarEstadisticas() {
        System.out.println("Ingresos Totales: " + calcularIngresosTotales() + "€");
        System.out.println("Contenido estrella: " + Collections.max(estadisticasContenido.entrySet(), Map.Entry.comparingByValue()).getKey());
    }
}