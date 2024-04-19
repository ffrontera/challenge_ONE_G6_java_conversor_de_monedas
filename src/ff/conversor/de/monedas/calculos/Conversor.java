package ff.conversor.de.monedas.calculos;

import ff.conversor.de.monedas.modelos.ConsultaCotizacion;

import java.util.Scanner;

public class Conversor {

    private ConsultaCotizacion cotizacion = new ConsultaCotizacion();

    public void convertirMoneda(String moneda1, String moneda2){
        float valorMoneda1 = cotizacion.obtenerCotizacion(moneda1);
        float valorMoneda2 = cotizacion.obtenerCotizacion(moneda2);
        float monto = obtenerMonto(moneda1, moneda2);
        float equicalenciaValor = valorMoneda2 / valorMoneda1 * monto;
        System.out.println("\n" + monto + " " + moneda1 + " equivalen a: " + equicalenciaValor + " " + moneda2);

    }

    private float obtenerMonto(String moneda1, String moneda2) {
        System.out.print("\nIngrese la cantidad de \"" + moneda1 + "\" a convertir a \"" + moneda2 + "\": ");
        Scanner input = new Scanner(System.in);
        float monto;
//        while (true) {
            monto = input.nextFloat();
//        }
        return monto;
    }
}
