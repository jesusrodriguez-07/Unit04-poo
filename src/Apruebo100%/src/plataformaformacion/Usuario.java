package plataformaformacion;

import java.util.Objects;

/**
 * Clase abstracta que representa un usuario genérico en la plataforma.
 * @author TuNombre
 */
public abstract class Usuario {
    private String id;
    private String nombre;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }

    /**
     * Método abstracto que cada tipo de usuario implementa según su cuota.
     * @return Ingresos generados por el usuario.
     */
    public abstract double calcularIngresos();

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Tipo: " + this.getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }
}

// --- SUBCLASES ---

class UsuarioGratuito extends Usuario {
    public UsuarioGratuito(String id, String nombre) { super(id, nombre); }
    @Override
    public double calcularIngresos() { return 0.0; } // No genera ingresos directos
}

class UsuarioMensual extends Usuario {
    public UsuarioMensual(String id, String nombre) { super(id, nombre); }
    @Override
    public double calcularIngresos() { return 15.0; } // Ejemplo: 15€ al mes
}

class UsuarioAnual extends Usuario {
    public UsuarioAnual(String id, String nombre) { super(id, nombre); }
    @Override
    public double calcularIngresos() { return 120.0; } // Ejemplo: 120€ al año
}