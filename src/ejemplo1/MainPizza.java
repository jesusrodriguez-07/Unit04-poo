package ejemplo1;


public class MainPizza {

	public static void main(String[] args) {

		Pizza pizza1 = new Pizza(Pizza.TamanoPizza.FAMILIAR, Pizza.TipoPizza.MARGARITA, Pizza.EstadoPizza.PEDIDA);
		
		System.out.println(pizza1.getTamano());
	}

}
