package crud4;

public class Disco {
    private String codigo;
    private String autor;
    private String titulo;
    private int duracion; // en minutos
    private String genero;

    public Disco(String codigo, String autor, String titulo, int duracion, String genero) {
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.duracion = duracion;
        setGenero(genero); // Usamos el setter para validar el género
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    
    public void setGenero(String genero) {
        // Validación básica de género
        String g = genero.toLowerCase();
        if (g.equals("rock") || g.equals("pop") || g.equals("jazz") || g.equals("blues")) {
            this.genero = genero;
        } else {
            this.genero = "Desconocido";
        }
    }

    // toString: Para que al hacer System.out.println(disco) salga bonito
    @Override
    public String toString() {
        return "ID: " + codigo + " | " + titulo + " - " + autor + " [" + genero + "] (" + duracion + " min)";
    }

    // equals: Muy importante para que el ArrayList sepa borrar o buscar
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Disco otro = (Disco) obj;
        return codigo.equals(otro.codigo); // Dos discos son iguales si tienen el mismo código
    }
}