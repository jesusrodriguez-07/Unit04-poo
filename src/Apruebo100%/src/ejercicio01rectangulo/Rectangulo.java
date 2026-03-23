package ejercicio01rectangulo;

public class Rectangulo {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public Rectangulo(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	public int getPerimetro(int x1, int x2, int y1, int y2) {
		int base = (x2-x1);
		int altura = (y1-x1);
		int perimetro = ((base+altura)*2);
		
		
		return perimetro;
	}
	
	public int getArea() {
		int base = (x2-x1);
		int altura = (y1-x1);
		int Area = (base*altura);
		return Area;
		
	}
}
