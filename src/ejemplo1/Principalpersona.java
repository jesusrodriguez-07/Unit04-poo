package ejemplo1;

import java.util.Scanner;

public class Principalpersona {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce la edad: ");
		
		int edad = sc.nextInt();
		
		
		Persona personaPrueba = new Persona("Daniel", edad, 1.74);
			
		System.out.println(personaPrueba.edad);
		
		sc.close();
		
//		Persona p1 = new Persona();
//		Persona p2 = new Persona();
		
//		Persona p3 = p1;
		
	}
}
