package ejemplo1;

public class Pizza {

	public Pizza(TamanoPizza tamano, TipoPizza tipo, EstadoPizza estado) {
		super();
		this.tamano = tamano;
		this.tipo = tipo;
		this.estado = estado;
	}
	
	private TamanoPizza tamano;
	private TipoPizza tipo;
	private EstadoPizza estado;
	
	public void servir() {
		estado = EstadoPizza.SERVIDA;
	}
	
	public enum TamanoPizza {
		MEDIANA, FAMILIAR
	}
	public enum TipoPizza {
		MARGARITA, BARBACOA, CUATRO_QUESOS, CARBONARA, PEPPERONI 
	}
	public enum EstadoPizza {
		PEDIDA, SERVIDA
	}
	
	
	public TamanoPizza getTamano() {
		return tamano;
	}
	public void setTamano(TamanoPizza tamano) {
		this.tamano = tamano;
	}
	public TipoPizza getTipo() {
		return tipo;
	}
	public void setTipo(TipoPizza tipo) {
		this.tipo = tipo;
	}
	public EstadoPizza getEstado() {
		return estado;
	}
	public void setEstado(EstadoPizza estado) {
		this.estado = estado;
	}
	
}
