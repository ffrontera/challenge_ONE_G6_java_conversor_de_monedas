package ff.conversor.de.monedas.principal;

import ff.conversor.de.monedas.modelos.ConsultaCotizacion;
import ff.conversor.de.monedas.modelos.MenuPrincipal;



public class Principal {

    public static void main(String[] args) {

        ConsultaCotizacion cotizacion = new ConsultaCotizacion();


        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.mostrarMenuPrincipal();

    }
}
