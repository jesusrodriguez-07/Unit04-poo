package crud2;

public class Articulo {
    private String codigo;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int stock;

    public Articulo(String codigo, String descripcion, double pCompra, double pVenta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = pCompra;
        this.precioVenta = pVenta;
        this.stock = stock;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public int getStock() { return stock; }
    
    // LÓGICA DE STOCK (Para no hacerlo en el Main)
    public void incrementarStock(int cantidad) {
        this.stock += cantidad;
    }

    public boolean decrementarStock(int cantidad) {
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
            return true;
        }
        return false; // No hay suficiente stock
    }

    @Override
    public String toString() {
        return "[" + codigo + "] " + descripcion + " | P.Compra: " + precioCompra + 
               " | P.Venta: " + precioVenta + " | Stock: " + stock;
    }
}