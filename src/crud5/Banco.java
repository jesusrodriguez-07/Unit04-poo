package crud5;

import java.util.ArrayList;

public class Banco {
    private ArrayList<CuentaCorriente> cuentas;

    public Banco() {
        this.cuentas = new ArrayList<>();
    }

    public void darAlta(CuentaCorriente c) {
        cuentas.add(c);
    }

    public void listarCuentas() {
        if (cuentas.isEmpty()) System.out.println("No hay cuentas registradas.");
        for (CuentaCorriente c : cuentas) System.out.println(c);
    }

    public CuentaCorriente buscarPorDni(String dni) {
        // Creamos una cuenta "ficticia" solo con el DNI para usar el equals
        int indice = cuentas.indexOf(new CuentaCorriente(dni));
        if (indice != -1) {
            return cuentas.get(indice);
        }
        return null;
    }

    public boolean eliminarCuenta(String dni) {
        return cuentas.remove(new CuentaCorriente(dni));
    }
}