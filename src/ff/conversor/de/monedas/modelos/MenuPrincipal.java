package ff.conversor.de.monedas.modelos;

import ff.conversor.de.monedas.calculos.CalculosArray;
import ff.conversor.de.monedas.calculos.Conversor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

    private final String[] OPCIONES_MENU_PRINCIPAL = {
            "Dólar =>> Peso argentino",
            "Peso argentino =>> Dólar",
            "Dólar =>> Real brasileño",
            "Real brasileño =>> Dólar",
            "Dólar =>> Peso colombiano",
            "Peso colombiano =>> Dólar",
            "Salir"};
    private final Scanner INPUT = new Scanner(System.in);
    private final String MENSAJE_ERROR = "ERROR! Debe ingresar un número del 1 al " + OPCIONES_MENU_PRINCIPAL.length;
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
            mostrarOpcionesMenuPrincipal();
            System.out.print("Elija una opción: ");
            opcion = elejirOpcion();
            salir = realizarSeleccion(opcion);
        }
        INPUT.close();
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

    private void mostrarOpcionesMenuPrincipal() {
        CalculosArray array = new CalculosArray();
        int anchoMenu = array.stringMasLargaArray(OPCIONES_MENU_PRINCIPAL) + ((OPCIONES_MENU_PRINCIPAL.length < 9) ? 0 : 1);
        String salida;
        for (int i = 0; i < OPCIONES_MENU_PRINCIPAL.length; i++) {
            salida = "";
            if (i == 0) {
                imprimiLineaVertical(anchoMenu);
            }
            salida = CARACTER_CAJA + " " + (i + 1) + " - " + OPCIONES_MENU_PRINCIPAL[i];
            while (salida.length() <= anchoMenu) {
                //salida = salida.substring(0, salida.length()-1);
                salida += " ";
            }
            System.out.println(salida + CARACTER_CAJA);
            if (i == OPCIONES_MENU_PRINCIPAL.length-1) {
                imprimiLineaVertical(anchoMenu);
            }
        }
    }

    private void imprimiLineaVertical(int anchoMenu) {
        for (int j = 0; j < anchoMenu + 8; j++) {
            System.out.print(CARACTER_CAJA);
        }
        System.out.println();
    }



    private int elejirOpcion() {
        int opcion;
        try {
            while (true) {
                opcion = INPUT.nextInt();
                if (opcion >= 1 && opcion <= OPCIONES_MENU_PRINCIPAL.length)
                    return opcion;
                else
                    System.out.println(MENSAJE_ERROR);
            }
        } catch (InputMismatchException e) {
                System.out.println(MENSAJE_ERROR);
        }
        return OPCIONES_MENU_PRINCIPAL.length;
    }
}
