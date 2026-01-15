package ejercicioB4;

public class Articulo {
	private String nombre = "Sin nombre";
	private double precio;
	private int iva = 21;
	private int cuantosQuedan;
	
	public Articulo(String nombre, double precio, int iva, int cuantosQuedan) {
		if (!nombre.isBlank()) {
			this.nombre = nombre;	
		}
		if (precio > 0) {
			this.precio = precio;	
		}
		if ( iva < 100 && iva > 0) {
			this.iva = iva;	
		}
		if (cuantosQuedan >= 0) {
			this.cuantosQuedan = cuantosQuedan;	
		}
	}
	
	public void setNombre (String nombre) {
		if (!nombre.isBlank()) {
			this.nombre = nombre;	
		}
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setPrecio(double precio) {
		if (precio > 0) {
			this.precio = precio;	
		}
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setIva(int iva) {
		if ( iva < 100 && iva > 0) {
			this.iva = iva;	
		}
	}
	
	public int getIva() {
	return iva;	
	}
	
	public void setCuantosQuedan(int cuantosQuedan) {
		if (cuantosQuedan >= 0) {
			this.cuantosQuedan = cuantosQuedan;	
		}
	}
	
	public int getCuantosQuedan() {
		return cuantosQuedan;
	}
	
	
}