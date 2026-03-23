package ejercicios4;

public class Contador {
	private int cont;
	
	public void setContador(int cont) {
		if (cont < 0) {
			this.cont = 0;
		} else {
			this.cont = cont;
		};
	}
	
	public int getContador() {
		return cont;
	}

	public Contador(int cont) {
		this.cont = cont;
	}
	
	public void incrementar(int incremento) {
		this.setContador(this.cont + incremento);
	}
	
	public void decremento(int decremento) {
		this.setContador(this.cont - decremento);
	}
	
	public String toString() {
		return "Contador | " + this.cont;
	}
}
