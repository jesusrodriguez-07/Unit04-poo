package biblioteca;
import java.util.ArrayList;

public class Socio {
    private String dni;
    private String nombre;
    private ArrayList<Libro> librosEnPrestamo = new ArrayList<>();
    private final int MAX_PRESTAMOS = 3; // Restricción del examen

    public Socio(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() { return dni; }
    
    public boolean puedeAlquilar() {
        return librosEnPrestamo.size() < MAX_PRESTAMOS;
    }

    public void añadirLibro(Libro l) { librosEnPrestamo.add(l); }
    public void quitarLibro(Libro l) { librosEnPrestamo.remove(l); }

    @Override
    public String toString() {
        return dni + " - " + nombre + " (Libros actuales: " + librosEnPrestamo.size() + ")";
    }
}