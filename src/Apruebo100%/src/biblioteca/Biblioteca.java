package biblioteca;
import java.util.HashMap;

public class Biblioteca {
    // Usamos HashMaps para buscar por ID rápido
    private HashMap<String, Libro> catalogo = new HashMap<>();
    private HashMap<String, Socio> registroSocios = new HashMap<>();

    // --- GESTIÓN LIBROS ---
    public boolean altaLibro(Libro l) {
        if (catalogo.containsKey(l.getIsbn())) return false;
        catalogo.put(l.getIsbn(), l);
        return true;
    }

    // --- GESTIÓN SOCIOS ---
    public boolean altaSocio(Socio s) {
        if (registroSocios.containsKey(s.getDni())) return false;
        registroSocios.put(s.getDni(), s);
        return true;
    }

    // --- OPERACIÓN PRESTAMO (EL CORAZÓN DEL EXAMEN) ---
    public String realizarPrestamo(String dni, String isbn) {
        Socio s = registroSocios.get(dni);
        Libro l = catalogo.get(isbn);

        if (s == null) return "Socio no encontrado.";
        if (l == null) return "Libro no encontrado.";
        if (!l.tieneDisponibilidad()) return "No quedan ejemplares libres.";
        if (!s.puedeAlquilar()) return "Socio ha alcanzado el límite (3).";

        // Si todo está ok, procedemos:
        l.prestar();
        s.añadirLibro(l);
        return "Préstamo realizado con éxito.";
    }

    public String realizarDevolucion(String dni, String isbn) {
        Socio s = registroSocios.get(dni);
        Libro l = catalogo.get(isbn);

        if (s != null && l != null) {
            l.devolver();
            s.quitarLibro(l);
            return "Devolución completada.";
        }
        return "Error en los datos.";
    }

    public void mostrarDisponibles() {
        for (Libro l : catalogo.values()) {
            if (l.tieneDisponibilidad()) System.out.println(l);
        }
    }
}