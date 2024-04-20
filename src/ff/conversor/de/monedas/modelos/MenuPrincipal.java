package ff.conversor.de.monedas.modelos;

import ff.conversor.de.monedas.calculos.CalculosArray;
import ff.conversor.de.monedas.calculos.Conversor;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuPrincipal {

    private final String MENSAJE_BIENVENIDA = """
                Conversor de monedas - Challenge ONE G6""";

    private final String[] OPCIONES_MENU_PRINCIPAL = {
            "Dólar =>> Peso argentino",
            "Peso argentino =>> Dólar",
            "Dólar =>> Real brasileño",
            "Real brasileño =>> Dólar",
            "Dólar =>> Peso colombiano",
            "Peso colombiano =>> Dólar",
            "Salir"};
    public static final Scanner INPUT = new Scanner(System.in);
    private final String MENSAJE_ERROR = "   ERROR! Debe ingresar un número del 1 al " + OPCIONES_MENU_PRINCIPAL.length;
    private final String MENSAJE_SALIR = """
            
               *********************************
               *Gracias por confiar en nosotros*
               *********************************
            
            Fin del programa.
            """;
    private final char CARACTER_CAJA = '*';
    private Conversor convertir = new Conversor();

    public void mostrarMenuPrincipal() {
        boolean salir = false;
        while (!salir) {
            int opcion;
            System.out.println();
            System.out.println(MENSAJE_BIENVENIDA);
            mostrarOpcionesMenuPrincipal();
            opcion = elejirOpcion();
            salir = realizarSeleccion(opcion);
        }
        INPUT.close();
    }

    private void mostrarOpcionesMenuPrincipal() {
        CalculosArray array = new CalculosArray();
        int anchoMenu = array.stringMasLargaArray(OPCIONES_MENU_PRINCIPAL) + 10 + ((OPCIONES_MENU_PRINCIPAL.length < 9) ? 0 : 1);
        String salida;
        for (int i = 0; i < OPCIONES_MENU_PRINCIPAL.length; i++) {
            salida = "";
            if (i == 0) {
                imprimiLineaVertical(anchoMenu);
            }
            salida = "   " + CARACTER_CAJA + " " + (i + 1) + " - " + OPCIONES_MENU_PRINCIPAL[i];
            while (salida.length() < anchoMenu) {
                salida += " ";
            }
            System.out.println(salida + "*");
            if (i == OPCIONES_MENU_PRINCIPAL.length-1) {
                imprimiLineaVertical(anchoMenu);
            }
        }
    }

    private int elejirOpcion() {
        int opcion;

        do {
            try {
                System.out.print("   Elija una opción: ");
                opcion = Integer.parseInt(INPUT.nextLine());
                if (opcion >= 1 && opcion <= OPCIONES_MENU_PRINCIPAL.length) {
                    return opcion;
                }
                else
                    System.out.println(MENSAJE_ERROR);
            } catch (NumberFormatException e) {
                System.out.println(MENSAJE_ERROR);
            }
        } while (true);


    }


    private void imprimiLineaVertical(int anchoMenu) {
        System.out.print("   ");
        for (int j = 0; j < anchoMenu -2; j++) {
            System.out.print(CARACTER_CAJA);
        }
        System.out.println();
    }

    private boolean realizarSeleccion(int opcion) {
        String moneda1, moneda2;
        switch (opcion){
            case 1:
                moneda1 = "USD";
                moneda2 = "ARS";
                break;
            case 2:
                moneda1 = "ARS";
                moneda2 = "USD";
                break;
            case 3:
                moneda1 = "USD";
                moneda2 = "BRL";
                break;
            case 4:
                moneda1 = "BRL";
                moneda2 = "USD";
                break;
            case 5:
                moneda1 = "UDS";
                moneda2 = "COP";
                break;
            case 6:
                moneda1 = "COP";
                moneda2 = "USD";
                break;
            default:
                System.out.println(MENSAJE_SALIR);
                return true;
        }
        convertir.convertirMoneda(moneda1, moneda2);
        return false;
    }
}
