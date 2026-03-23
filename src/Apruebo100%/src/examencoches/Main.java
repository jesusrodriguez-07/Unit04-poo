package examencoches;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Creamos el gestor que contiene la lista
		ListaVehiculos coches = new ListaVehiculos();

		System.out.println();

		int opcion = 0;
		// Declaramos variables fuera del switch para poder reutilizarlas
		String matricula = "";
		String modelo = "";
		double precio = 0.0;
		double porcentaje = 0.0;

		do {
			try { // Bloque protector contra errores de teclado
				System.out.println("1. Añadir vehiculo");
				System.out.println("2. Listar vehiculos ");
				System.out.println("3. Buscar vehiculo por matricula ");
				System.out.println("4. Modificar dias alquilados ");
				System.out.println("5. Modificar recargo premium ");
				System.out.println("6. Modificar precio seguro diario");
				System.out.println("7. Eliminar vehiculo");
				System.out.println("8. Ver estadisticas");
				System.out.println("9. Salir ");

				// Leemos la opción como String y la pasamos a Int (Evita bugs de Scanner)
				opcion = Integer.parseInt(sc.nextLine());

				switch (opcion) {
				case 1:
					System.out.println(
							"Introduce la matricula del coche, el modelo, el precio base por dia, y el porcentaje de recargo premium 1 por 1");
					matricula = sc.nextLine();
					modelo = sc.nextLine();
					precio = Double.parseDouble(sc.nextLine());
					porcentaje = Double.parseDouble(sc.nextLine());

					// Construimos el objeto y tratamos de añadirlo
					Vehiculo nuevoCoche = new Vehiculo(matricula, modelo, precio, porcentaje);
					if (coches.añadirVehiculo(nuevoCoche) == true) {
						System.out.println("El coche se ha introducido correctamente");
					} else {
						System.out.println("Ha ocurrido un error (Matrícula duplicada)");
					}
					break;

				case 2:
					coches.listarTodos();
					break;

				case 3:
					System.out.println("Introduce la matricula de la que quieres buscar el coche");
					matricula = sc.nextLine();
					Vehiculo encontrado = coches.buscarMatricula(matricula);
					if (encontrado != null) {
						System.out.println("Vehiculo encontrado: " + encontrado);
					} else {
						System.out.println("El vehiculo no esta listado");
					}
					break;

				case 4:
					System.out.println("Introduce la matricula del coche");
					matricula = sc.nextLine();
					System.out.println("Introduce los dias de alquiler:");
					int dias = Integer.parseInt(sc.nextLine());
					if (coches.modificarDiasAlquilados(matricula, dias) == true) {
						System.out.println("Se ha modificado correctamente");
					} else {
						System.out.println("Ha habido un error (Matrícula no encontrada)");
					}
					break;

				case 5:
					System.out.println("Introduce la matricula del coche");
					matricula = sc.nextLine();
					System.out.println("Introduce el porcentaje de recargo entre 0 y 25%");
					porcentaje = Double.parseDouble(sc.nextLine());

					// Validamos el rango antes de hacer nada
					if (porcentaje <= 25 && porcentaje >= 0) {
						if (coches.modificarRecargoPremium(matricula, porcentaje)) {
							System.out.println("Porcentaje modificado correctamente");
						} else {
							System.out.println("Error no existe ese vehiculo");
						}
					} else {
						System.out.println("Introduce un valor del porcentaje dentro del rango (0-25)");
					}
					break;

				case 6:
					System.out.println("Introduce el nuevo precio del seguro (para todos):");
					precio = Double.parseDouble(sc.nextLine());
					// Llamada estática: Usamos la Clase 'Vehiculo', no el objeto
					Vehiculo.setPrecioSeguro(precio);
					break;

				case 7:
					System.out.println("Introduce la matricula del coche a eliminar");
					matricula = sc.nextLine();
					if (coches.eliminarPorMatricula(matricula) == true) {
						System.out.println("El coche se ha eliminado correctamente");
					} else {
						System.out.println("Ha ocurrido un error (Matrícula no encontrada)");
					}
					break;

				case 8:
					// Mostramos las dos estadísticas juntas
					double ingreso = coches.calcularIngresoTotalRecargos();
					System.out.println("Ingresos totales por premium: " + ingreso);
					System.out.println("Vehículos con recargo > 12%:");
					coches.listarVehiculosPremium();
					break;

				case 9:
					System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
					break;

				default:
					System.out.println("Opción no válida");
				}

			} catch (NumberFormatException e) {
				// Si el usuario mete una letra donde va un número, el programa no explota
				System.out.println("Error: Introduce un número válido");
			}
		} while (opcion != 9);

		sc.close();
	}
}