package inventario;

public class Producto {
	private String nombre;
	private double precio;
	
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		setPrecio(precio);
	}
	
	public Producto(String nombre) {
		this.nombre = nombre;
	}
	
	public Producto() {
		
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio > 0) {
		this.precio = precio;	
		} else {
			System.out.println("Tienes que introducir un precio valido");
			this.precio = 0;
		}
	}
	
	public String toString() {
		return "Nombre del producto | " + this.getNombre() + " con precio | " + this.getPrecio();
	}

}

	
