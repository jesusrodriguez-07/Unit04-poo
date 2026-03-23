package Soldadito;

public class Soldado {

	// Estos son los atributos de la clase y metodos para crearlo con sus atributos ya llenos y para poder controlar los datos que metemos
	private String nombre;
	private int salud;
	
	
	public Soldado(String nombre, int salud) {
		this.nombre = nombre;
		setSalud(salud);
	}
	
	public Soldado(String nombre) {
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getSalud() {
		return salud;
	}


	public void setSalud(int salud) {
		if (salud < 0) {
			System.out.println("Tienes que introducir un valor correcto para la salud joder");
			this.salud = 0;
		} else {
			this.salud = salud;	
		}
	}
	
	// Metodos estos son los metodos para que haga algo el objeto y esto se suele usar en otra clase de gestion pero aqui al principio vamos a usarlo en la clase en si
	
	public void presentarse() {
		System.out.println("Hola soy " + this.nombre + " y tengo " + salud + " de vida" );
	}
	
	public void recibirDaño(int cantidad) {
		int nuevaSalud = this.getSalud() - cantidad;
		this.setSalud(nuevaSalud);
	}
	
}
