package ff.conversor.de.monedas.modelos;

import static ff.conversor.de.monedas.modelos.MenuPrincipal.INPUT;

public class MenuEleccionMoneda {

    private final   String MONEDAS_DISPONIBLES = """              
               ARS - Peso argentino	             - Argentina
               BOB - boliviano boliviano	     - Bolivia
               BRL - Real brasileño	             - Brasil
               CHF - Franco suizo	             - Suiza
               CLP - Peso chileno	             - Chile
               EUR - Euro	                     - unión Europea
               FKP - Libra de las Islas Malvinas - Islas Malvinas
               GBP - Libra esterlina	         - Reino Unido
               JPY - Yen japonés	             - Japón
               KYD - Dólar de las Islas Caimán	 - Islas Caimán
               MXN - Peso mexicano	             - México
               NZD - Dolar de Nueva Zelanda	     - Nueva Zelanda
               PEN - Soles peruanos              - Perú
               PYG - Guaraní paraguayo	         - Paraguay         
               USD - Dólar de los Estados Unidos - Estados Unidos
               UYU - Peso uruguayo	             - Uruguay
               VES - Bolívar Soberano venezolano - Venezuela                                  
            """;

    private void mostrarMenuSeleccionarMonedas() {
        System.out.println("""
                La aplicación soporta la mayoria de los codigos de moneda ISO-4217.
                   A continuacion se muestran algunos ejemplos:\n""");
        System.out.println(MONEDAS_DISPONIBLES);
    }

    public String[] seleccionarMonedas() {
        String moneda1;
        String moneda2 = "VES";
        String[] aux = new String[2];
        mostrarMenuSeleccionarMonedas();
        System.out.print("   Ingrese el código de moneda que quiere cambiar: ");
        moneda1 = INPUT.nextLine();
        System.out.print("   Ingrese el código de moneda al que quiere convertir: ");
        moneda2 = INPUT.nextLine();
        aux[0] = moneda1.toUpperCase();
        aux[1] = moneda2.toUpperCase();
        return aux;
    }
}
