package inventario;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Producto producto = new Producto();
		Inventario miGestor = new Inventario();
		
		
		System.out.println("Introduce el nombre de un producto y separado con coma el precio de este");
		String mensaje = sc.nextLine();
		String[] valoresMensaje = mensaje.split(",");
		producto.setNombre(valoresMensaje[0]);
		producto.setPrecio(Double.parseDouble(valoresMensaje[1]));
		
		
		System.out.println("Si quieres introducir productos introduce la letra s si no introduce cualquier otra letra");
		char seguir = sc.nextLine().trim().charAt(0);
		
		while (seguir == 'S' || seguir == 's') {
			System.out.println("Introduce el nombre de un producto y separado con coma el precio de este");
			String nuevoMensaje = sc.nextLine();
			String[] nuevosValoresMensaje = nuevoMensaje.split(",");
			
			Producto nuevoProducto = new Producto();
			nuevoProducto.setNombre(nuevosValoresMensaje[0]);
			nuevoProducto.setPrecio(Double.parseDouble(nuevosValoresMensaje[1]));
			System.out.println("Si quieres introducir mas productos introduce la letra s si no introduce cualquier otra letra");
			seguir = sc.nextLine().trim().charAt(0);
		};
		
		int opcion = 0;
		do {
			System.out.println("1. Mostrar precio mayor a 50");
			System.out.println("2. Mostrar nombres de los productos");
			
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				miGestor.mostrarPrecioMasAlto();
				break;
			
			case 2: 
				miGestor.Read();
				break;
				
			case 8: 
				System.out.println("Salir...");
			default:
				System.out.println("Introduce un valor que sea guay");
			}
		} while(opcion != 8);
		System.out.println(producto);
		
		miGestor.mostrarPrecioMasAlto();
		
		sc.close();
	}

}
