package ff.conversor.de.monedas.principal;

import ff.conversor.de.monedas.modelos.MenuPrincipal;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
//        String moneda = "ARS";
//
//        ConsultaCotizacion cotizacion = new ConsultaCotizacion();
//        float valor = cotizacion.obtenerCotizacion(moneda);
//        System.out.println(valor);



        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.mostrarMenuPrincipal();

    }
}
