package crud5;

public class CuentaCorriente {
    private String dni;
    private String nombreTitular;
    private double saldo;

    // Constructor completo (Alta)
    public CuentaCorriente(String dni, String nombreTitular, double saldoInicial) {
        this.dni = dni;
        this.nombreTitular = nombreTitular;
        this.saldo = saldoInicial;
    }

    // Constructor solo con DNI (Útil para búsquedas/borrados)
    public CuentaCorriente(String dni) {
        this.dni = dni;
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public String getNombreTitular() { return nombreTitular; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    // Métodos de lógica bancaria
    public void ingresar(double cantidad) {
        if (cantidad > 0) this.saldo += cantidad;
    }

    public boolean sacar(double cantidad) {
        if (cantidad > 0 && this.saldo >= cantidad) {
            this.saldo -= cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + " | Titular: " + nombreTitular + " | Saldo: " + saldo + "€";
    }

    // Equals basado en DNI para que el ArrayList sepa encontrar la cuenta
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CuentaCorriente otra = (CuentaCorriente) obj;
        return dni.equalsIgnoreCase(otra.dni);
    }
}