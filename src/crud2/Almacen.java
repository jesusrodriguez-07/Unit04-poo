package crud2;

import java.util.ArrayList;

public class Almacen {
    private ArrayList<Articulo> inventario;

    public Almacen() {
        this.inventario = new ArrayList<>();
    }

    public void alta(Articulo a) { inventario.add(a); }

    public boolean baja(String codigo) {
        return inventario.removeIf(a -> a.getCodigo().equals(codigo));
    }

    public void listado() {
        if (inventario.isEmpty()) System.out.println("Almacén vacío.");
        for (Articulo a : inventario) System.out.println(a);
    }

    // MÉTODO CLAVE: Buscar un artículo por su código
    public Articulo buscar(String codigo) {
        for (Articulo a : inventario) {
            if (a.getCodigo().equals(codigo)) return a;
        }
        return null;
    }
}