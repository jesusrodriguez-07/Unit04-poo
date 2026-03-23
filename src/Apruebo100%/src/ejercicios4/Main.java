package ejercicios4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean objetoBien = false;
		Contador cont = null;
		do {
			try {
				System.out.println("Introduce un valor para contador");
				int ingreso = Integer.parseInt(sc.nextLine());
				cont = new Contador(ingreso);
				objetoBien = true;
				
				System.out.println(cont);
	
			} catch (Exception e) {
				System.out.println("Que nooooo");
			}
		} while (!objetoBien);	
		String accion = "";
		
		do {
		System.out.println("Quieres incrementar o decrementar el valor del contador? o salir inc/dec/salir");
		accion = sc.next();
		sc.nextLine();
		
		
		try {
			if (accion.equalsIgnoreCase("inc")) {
				System.out.println("Introduce el número que quieres incrementar");
				int incremento = Integer.parseInt(sc.nextLine());
				cont.incrementar(incremento);
			} else if (accion.equalsIgnoreCase("dec")){
				System.out.println("Introduce el número que quieres decrementar");
				int decremento = Integer.parseInt(sc.nextLine());
				cont.decremento(decremento);
			} else if (accion.equals("salir")){
				System.out.println("Saliendo del sistema...");
			} else {
				System.out.println("Introduce un valor correcto");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Eso que e churrita venga anda");
		}
		
		System.out.println(cont);
		} while (!accion.equalsIgnoreCase("salir"));
		
		
		sc.close();
	}

}
