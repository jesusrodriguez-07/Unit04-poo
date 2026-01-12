package ejemplo1;

public class Principalpersona {

	public static void main (String[] args) {
		Persona daniel = new Persona();
		
		System.out.println(daniel);
		System.out.println(daniel.nombre);
		daniel.nombre = "Daniel";
		System.out.println(daniel.nombre);
		System.out.println(daniel.edad);
		System.out.println(daniel.estatura);
		System.out.println(daniel.carnet);
		daniel.genero = "Mujer";
		System.out.println(daniel.genero);
		
//		Persona p1 = new Persona();
//		Persona p2 = new Persona();
		
//		Persona p3 = p1;
		
	}
}
