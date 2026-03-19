package crud3;

import java.util.ArrayList;

public class Pizzeria {
    private ArrayList<Pizza> pedidos;

    public Pizzeria() {
        this.pedidos = new ArrayList<>();
    }

    public void nuevoPedido(Pizza p) {
        pedidos.add(p);
    }

    public void mostrarListado() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos hoy.");
        } else {
            for (int i = 0; i < pedidos.size(); i++) {
                // Mostramos un índice para que el usuario pueda elegir cuál servir
                System.out.println((i + 1) + ". " + pedidos.get(i));
            }
        }
    }

    // Método para obtener una pizza por su posición en la lista
    public Pizza getPizza(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            return pedidos.get(indice);
        }
        return null;
    }
}