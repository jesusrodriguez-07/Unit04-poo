package examencoches;

import java.util.ArrayList;

public class ListaVehiculos {

	// El ArrayList donde se guardan físicamente los objetos Vehiculo
	private ArrayList<Vehiculo> lista = new ArrayList<>();

	// CREATE: Añadir un vehículo si no existe ya su matrícula
	public boolean añadirVehiculo(Vehiculo v) {
		boolean añadido = false;

		// Primero buscamos la matrícula. Si da 'null', es que está libre.
		if (this.buscarMatricula(v.getMatricula()) == null) {
			lista.add(v);
			añadido = true;
		}

		return añadido;
	}

	// READ: Imprimir todos los coches del garaje
	public void listarTodos() {
		for (Vehiculo v : lista) {
			System.out.println(v); // Llama al toString() de cada coche
		}
	}

	// EL BUSCADOR (MÉTODO CLAVE): Devuelve el objeto coche entero o 'null'
	public Vehiculo buscarMatricula(String matricula) {
		Vehiculo vehiculoEncontrado = null;

		for (Vehiculo v : lista) {
			// Comparamos Strings con .equals()
			if (v.getMatricula().equals(matricula)) {
				vehiculoEncontrado = v;
				break; // Si lo encontramos, dejamos de buscar
			}
		}
		return vehiculoEncontrado;
	}

	// UPDATE: Cambiar los días de alquiler
	public boolean modificarDiasAlquilados(String matricula, int dias) {
		boolean modificado = false;

		// Buscamos el coche por matrícula
		Vehiculo objetivo = this.buscarMatricula(matricula);

		if (objetivo != null) {
			objetivo.setDiasAlquiler(dias); // Aplicamos el cambio
			modificado = true;
		}

		return modificado;
	}

	// UPDATE: Cambiar el porcentaje premium
	public boolean modificarRecargoPremium(String matricula, double porcentaje) {
		boolean modificado = false;

		Vehiculo objetivo = this.buscarMatricula(matricula);

		if (objetivo != null) {
			objetivo.setPorcentajePremium(porcentaje);
			modificado = true;
		}

		return modificado;
	}

	// DELETE: Eliminar un coche de la lista
	public boolean eliminarPorMatricula(String matricula) {
		boolean eliminado = false;
		for (Vehiculo v : lista) {
			if (v.getMatricula().equals(matricula)) {
				lista.remove(v); // Borramos el objeto de la lista
				eliminado = true;
				break;
			}
		}
		return eliminado;
	}

	// ESTADÍSTICA: Sumar todos los recargos premium del garaje
	public double calcularIngresoTotalRecargos() {
		double suma = 0;

		for (Vehiculo v : lista) {
			suma = suma + v.devolverPremium();
		}
		return suma;
	}

	// ESTADÍSTICA: Listar solo los coches con recargo > 12%
	public void listarVehiculosPremium() {
		for (Vehiculo v : lista) {
			// Usamos el método boolean que creamos en Vehiculo
			if (v.Premium() == true) {
				System.out.println(v);
			}
		}
	}
}