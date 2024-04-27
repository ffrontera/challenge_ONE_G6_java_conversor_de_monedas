package ff.conversor.de.monedas.calculos;

import static ff.conversor.de.monedas.modelos.MenuPrincipal.INPUT;

import ff.conversor.de.monedas.modelos.Conversion;
import ff.conversor.de.monedas.modelos.ModificarArchivo;
import ff.conversor.de.monedas.modelos.Moneda;


import java.io.IOException;
import java.text.DecimalFormat;

public class Conversor {

    private  DecimalFormat formatoDecimal = new DecimalFormat("0.00");
    private Conversion conversion;

    private HoraFechaActual horaFecha = new HoraFechaActual();

    private  ModificarArchivo archivo = new ModificarArchivo();

    public void convertirMoneda(String moneda1, String moneda2, Moneda cotizaciones){
        try {
            float valorMoneda1 = cotizaciones.getMoneda(moneda1);
            float valorMoneda2 = cotizaciones.getMoneda(moneda2);
            float monto = obtenerMonto(moneda1, moneda2);
            float tasaConversion = valorMoneda2 / valorMoneda1;
            String salida = formatoDecimal.format(tasaConversion * monto);
            System.out.println("\n   " + monto + " " + moneda1 + " equivalen a: " + salida + " " + moneda2);
            conversion = new Conversion(moneda1, monto, moneda2, salida, horaFecha.horaFechaActual(), formatoDecimal.format(tasaConversion));
            archivo.guardarConversion(conversion);
        } catch (NullPointerException e) {
            System.out.println("   ERROR! Ocurrio un problema y no pudimos obtener la cotizacion de alguna de las monedas.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private float obtenerMonto(String moneda1, String moneda2) {

        float monto;
        while (true) {
            try {
                System.out.print("\n   Ingrese la cantidad de \"" + moneda1 + "\" a convertir a \"" + moneda2 + "\": ");
                monto = Integer.parseInt(INPUT.nextLine());
                return monto;
            } catch (NumberFormatException e) {
                System.out.println("   ERROR! El monto a ingresar debe ser en número. Ej: 1200.10");
            }
        }
    }
}
