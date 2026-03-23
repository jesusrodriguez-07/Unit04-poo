package inventario;

import java.util.ArrayList;

public class Inventario {
	private ArrayList <Producto> lista = new ArrayList<>();

	
	public void Create(Producto p1){
		lista.add(p1);
	}
	
	public void Read() {
		for (Producto p:lista) {
			System.out.println(p.toString());
		}
	}
	
	public boolean Update(String objetoACambiar, double precioNuevo) {
		boolean precioCambiado = true;
		
		for ( int i = 0; i < lista.size();i++) {
			Producto p = lista.get(i);
			
			if (p.getNombre().equalsIgnoreCase(objetoACambiar) ) {
				p.setPrecio(precioNuevo);
			} else {
				precioCambiado = false;
			}
		}
		return precioCambiado;
	}
	
	public boolean Delete(String nombreBorrar) {
		boolean estaba = true;
		for (int i = 0; i < lista.size();i++) {
			Producto sospechoso = lista.get(i);
			
			if (sospechoso.getNombre().equalsIgnoreCase(nombreBorrar)) {
				lista.remove(i);
			} else {
				estaba = false;
			}
		}
		return estaba;
	}
	
	
	public void mostrarPrecioMasAlto() {
		for (Producto p : lista) {
			if (p.getPrecio() > 50) {
				System.out.println(p + " Precio mayor a 50");
			}
		}
	}
	
	
}
