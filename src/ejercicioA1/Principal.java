package ejercicioA1;

public class Principal {
	public static void main(String[] args) {

		Punto p1 = new Punto();
		Punto p2 = new Punto();
		Punto p3 = new Punto();

		p1.x = 5;

		p2.x = 10;
		p2.y = 10;

		p3.x = -3;
		p3.y = 7;

		System.out.println("p1: " + "(" + p1.x + "," + p1.y + ")");
		System.out.println("p2: " + "(" + p2.x + "," + p2.y + ")");
		System.out.println("p3: " + "(" + p3.x + "," + p3.y + ")");

		p1.x = p1.x + 5;
		p1.y = p2.x - 5;

		p2.y *= 2;

		p3.x += 2;

		System.out.println("p1: " + "(" + p1.x + "," + p1.y + ")");
		System.out.println("p2: " + "(" + p2.x + "," + p2.y + ")");
		System.out.println("p3: " + "(" + p3.x + "," + p3.y + ")");

	}
}
