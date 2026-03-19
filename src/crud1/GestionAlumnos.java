package crud1;

import java.util.ArrayList;

public class GestionAlumnos {
    private ArrayList<Alumno> lista;

    public GestionAlumnos() {
        this.lista = new ArrayList<>();
    }

    // C (Create) - Nuevo Alumno
    public void añadirAlumno(Alumno a) {
        lista.add(a);
    }

    // R (Read) - Listado
    public void listarAlumnos() {
        if (lista.isEmpty()) {
            System.out.println("No hay alumnos en la lista.");
        } else {
            for (Alumno a : lista) {
                System.out.println(a); // Llama al toString() automáticamente
            }
        }
    }

    // U (Update) - Modificar nota por nombre
    public boolean modificarNota(String nombre, double nuevaNota) {
        for (Alumno a : lista) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                a.setNota(nuevaNota);
                return true;
            }
        }
        return false;
    }

    // D (Delete) - Borrar por nombre
    public boolean borrarAlumno(String nombre) {
        // Usamos un bucle tradicional o removeIf para evitar errores de concurrencia
        return lista.removeIf(a -> a.getNombre().equalsIgnoreCase(nombre));
    }
}