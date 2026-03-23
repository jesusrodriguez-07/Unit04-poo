package biblioteca;
import java.util.Objects;

public class Libro {
    private String isbn; // Identificador único
    private String titulo;
    private int ejemplares; // Cuántos hay en total
    private int prestados;   // Cuántos están fuera ahora mismo

    public Libro(String isbn, String titulo, int ejemplares) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.ejemplares = ejemplares;
        this.prestados = 0; // Al empezar, ninguno está prestado
    }

    // Getters y Setters
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public int getEjemplares() { return ejemplares; }
    public int getPrestados() { return prestados; }

    // LÓGICA DE DISPONIBILIDAD
    public boolean tieneDisponibilidad() {
        return prestados < ejemplares;
    }

    public void prestar() { prestados++; }
    public void devolver() { prestados--; }

    @Override
    public String toString() {
        return "[" + isbn + "] " + titulo + " (Disponibles: " + (ejemplares - prestados) + "/" + ejemplares + ")";
    }

    // Equals por ISBN (para no duplicar)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn);
    }
}