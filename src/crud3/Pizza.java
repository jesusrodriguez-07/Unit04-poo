package crud3;

public class Pizza {
    private String tamano; // Mediana o Familiar
    private String tipo;   // Margarita, Cuatro Quesos, Funghi
    private String estado; // "Pedida" o "Servida"

    public Pizza(String tamano, String tipo) {
        this.tamano = tamano;
        this.tipo = tipo;
        this.estado = "Pedida"; // Por defecto, toda pizza nueva está pendiente
    }

    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }

    // Método para cambiar el estado
    public void servir() {
        this.estado = "Servida";
    }

    @Override
    public String toString() {
        return "Pizza " + tipo + " (" + tamano + ") - Estado: " + estado;
    }
}