package crud4;

import java.util.ArrayList;

public class Coleccion {
    private ArrayList<Disco> lista;

    public Coleccion() {
        this.lista = new ArrayList<>();
    }

    public void listado() {
        if (lista.isEmpty()) {
            System.out.println("La colección está vacía.");
        } else {
            for (Disco d : lista) {
                System.out.println(d);
            }
        }
    }

    public void nuevoDisco(Disco d) {
        lista.add(d);
    }

    public boolean borrarDisco(String codigo) {
        // removeIf recorre la lista y borra si el código coincide
        return lista.removeIf(d -> d.getCodigo().equals(codigo));
    }
}