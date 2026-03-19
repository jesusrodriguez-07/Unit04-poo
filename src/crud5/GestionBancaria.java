package crud5;

import java.util.Scanner;

public class GestionBancaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco miBanco = new Banco();
        int opcion;

        do {
            System.out.println("\nCAJERO AUTOMÁTICO\n1. Listado de cuentas\n2. Nueva cuenta\n3. Modificar saldo (Ingreso/Retirada)\n4. Borrar cuenta\n5. Salir");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1:
                    miBanco.listarCuentas();
                    break;
                case 2:
                    System.out.print("DNI: "); String dni = sc.nextLine();
                    System.out.print("Nombre Titular: "); String nom = sc.nextLine();
                    System.out.print("Saldo Inicial: "); double s = sc.nextDouble();
                    miBanco.darAlta(new CuentaCorriente(dni, nom, s));
                    break;
                case 3:
                    System.out.print("DNI de la cuenta: ");
                    CuentaCorriente c = miBanco.buscarPorDni(sc.nextLine());
                    if (c != null) {
                        System.out.print("1. Ingresar / 2. Sacar: ");
                        int mov = sc.nextInt();
                        System.out.print("Cantidad: ");
                        double cant = sc.nextDouble();
                        if (mov == 1) c.ingresar(cant);
                        else if (!c.sacar(cant)) System.out.println("Saldo insuficiente.");
                    } else System.out.println("Cuenta no encontrada.");
                    break;
                case 4:
                    System.out.print("DNI a borrar: ");
                    if (miBanco.eliminarCuenta(sc.nextLine())) System.out.println("Cuenta eliminada.");
                    else System.out.println("No existe esa cuenta.");
                    break;
            }
        } while (opcion != 5);
    }
}