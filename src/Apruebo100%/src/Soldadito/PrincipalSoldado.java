package Soldadito;

public class PrincipalSoldado {

	public static void main(String[] args) {
		// En el examen no puedo comentar demasiado y no puedo no hacer cosas como las constantes
		
		Soldado misoldado = new Soldado("roiger");

		misoldado.setNombre("Soldado76");
		misoldado.getNombre();
		
		// Este valor no es el real porque si es negativo da 0 mediante la validacion de setSalud
		// misoldado.setSalud(-120);
		
		misoldado.setSalud(120);
		misoldado.presentarse();
		
		misoldado.recibirDaño(20);
		misoldado.presentarse();
		
	}

}
