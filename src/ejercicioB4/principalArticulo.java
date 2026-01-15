package ejercicioB4;

public class principalArticulo {

	public static void main(String[] args) {
		
		Articulo articulo1 = new Articulo("Pijama", 10.0, 21, 50);
		Articulo articulo2 = new Articulo("Zapato", -20.0, 210, -5);
		
		mostrar(articulo1);
		mostrar(articulo2);
	
		articulo1.setNombre("Paraguas");
		
	}
	
	static void mostrar(Articulo articulo) {
		System.out.println(articulo.getNombre() + "| Precio: " + articulo.getPrecio() + "| IVA: " + articulo.getIva() + "%" + "| Stock: " + articulo.getCuantosQuedan());
	}
 
}
