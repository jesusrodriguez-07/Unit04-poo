package plataformaformacion;

/**
 * Representa un contenido educativo de la plataforma.
 */
public class Contenido {
    private String titulo;
    private int duracion; // en minutos
    private String nivel; // basico, intermedio, avanzado

    public Contenido(String titulo, int duracion, String nivel) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.nivel = nivel;
    }

    public String getTitulo() { return titulo; }

    @Override
    public String toString() {
        return titulo + " (" + nivel + ") - " + duracion + " min.";
    }
}