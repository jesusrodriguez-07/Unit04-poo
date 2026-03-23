package examencoches;

import java.util.Objects;

public class Vehiculo {
	// ATRIBUTOS: Los datos que guarda cada coche
	private String matricula;
	private String modelo;
	private double precioBase;
	private double porcentajePremium;
	// STATIC: Este dato es compartido. Si cambias 'precioSeguro', cambia para todos
	// los coches.
	private static double precioSeguro;
	private int diasAlquiler;

	// GETTERS Y SETTERS: Las puertas para leer o escribir en los atributos privados
	public String getMatricula() {
		return matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public double getPorcentajePremium() {
		return porcentajePremium;
	}

	public void setPorcentajePremium(double porcentajePremium) {
		this.porcentajePremium = porcentajePremium;
	}

	// Getter y Setter estáticos: Se usan para el seguro global
	public static double getPrecioSeguro() {
		return precioSeguro;
	}

	public static void setPrecioSeguro(double precioSeguro) {
		Vehiculo.precioSeguro = precioSeguro;
	}

	public int getDiasAlquiler() {
		return diasAlquiler;
	}

	public void setDiasAlquiler(int diasAlquiler) {
		this.diasAlquiler = diasAlquiler;
	}

	// CONSTRUCTORES: Diferentes formas de crear un coche
	public Vehiculo(String matricula, String modelo, double precioBase, double porcentajePremium, int diasAlquiler) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.setPrecioBase(precioBase);
		this.setPorcentajePremium(porcentajePremium);
		this.setDiasAlquiler(diasAlquiler);
	}

	public Vehiculo(String matricula, String modelo, double precioBase, int diasAlquiler) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.setPrecioBase(precioBase);
		this.setDiasAlquiler(diasAlquiler);
	}

	// El constructor que usas en el Case 1 (4 parámetros)
	public Vehiculo(String matricula, String modelo, double precioBase, double porcentajePremium) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.setPrecioBase(precioBase);
		this.setPorcentajePremium(porcentajePremium);
		// Importante: diasAlquiler no se pasa, así que Java lo deja a 0 por defecto.
	}

	// MÉTODOS DE CÁLCULO: La "inteligencia" del coche
	public double devolverPremium() {
		// Calcula el dinero extra: (Base * Porcentaje) / 100
		double recargoPremium = this.getPrecioBase() * this.getPorcentajePremium() / 100.0;
		return recargoPremium;
	}

	public double devolverImporteSeguro() {
		// Días del coche multiplicado por el precio global (static)
		double importe = this.getDiasAlquiler() * Vehiculo.getPrecioSeguro();
		return importe;
	}

	public double devolverIngresoTotal() {
		// Suma de todo: Base + Extra Premium + Seguro
		double ingreso = this.getPrecioBase() + this.devolverPremium() + this.devolverImporteSeguro();
		return ingreso;
	}

	// toString: Cómo se muestra el coche al hacer un System.out.println
	public String toString() {
		return this.matricula + " - " + this.modelo + "\n" + "Precio Base/Día: " + this.precioBase
				+ " | Recargo Premium: " + this.devolverPremium() + " (" + this.porcentajePremium + "%)\n"
				+ "Días alquilado: " + this.diasAlquiler + " | Total generado: " + this.devolverIngresoTotal();
	}

	// Método para saber si es Premium (> 12%)
	public boolean Premium() {
		return this.getPorcentajePremium() > 12;
	}

	// EQUALS: Para que la lista sepa que dos coches son iguales si tienen la misma
	// matrícula
	public int hashCode() {
		return Objects.hash(matricula);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}
}