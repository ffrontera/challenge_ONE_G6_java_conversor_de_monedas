package ff.conversor.de.monedas.modelos;

import com.google.gson.Gson;
import ff.conversor.de.monedas.calculos.CalculosArray;
import ff.conversor.de.monedas.calculos.Conversor;

import java.io.FileNotFoundException;
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
            "Elegir monedas.",
            "Historial conversiones",
            "Salir"};
    public static final Scanner INPUT = new Scanner(System.in);
    private final String MENSAJE_ERROR = "   ERROR! Debe ingresar un número del 1 al " + OPCIONES_MENU_PRINCIPAL.length;
    private final String MENSAJE_SALIR = """
            
               *********************************
               *   Gracias por tu confianza!   *
               *********************************
            
               *********Fin del programa********
            """;
    private final char CARACTER_CAJA = '*';
    private Conversor convertir = new Conversor();
    private ConsultaCotizacion consultaApi = new ConsultaCotizacion();
    private Moneda cotizaciones = consultaApi.obtenerCotizacion();
    private MenuEleccionMoneda menu2 = new MenuEleccionMoneda();

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
        String moneda1 = "", moneda2 = "";
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
                moneda1 = "USD";
                moneda2 = "COP";
                break;
            case 6:
                moneda1 = "COP";
                moneda2 = "USD";
                break;
            case 7:
                String[] aux = menu2.seleccionarMonedas();
                moneda1 = aux[0];
                moneda2 = aux[1];
                break;
            case 8: //al agregar una opcion al menu principal, agregar el tratamiento a este numero de caso, y el caso actual moverlo a este numero + 1.
                ModificarArchivo archivo = new ModificarArchivo();
                Gson gson = new Gson();
                try {
                    String json = archivo.leerArchivo();
                    ListaConversiones lista = gson.fromJson(json, ListaConversiones.class);
                    System.out.println();
                    System.out.println(lista);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (NullPointerException e) {
                    System.out.println("No hay conversiones para mostrar.");
                }
                break;
            default:
                System.out.println(MENSAJE_SALIR);
                return true;
        }
        if (opcion < OPCIONES_MENU_PRINCIPAL.length-1)
            convertir.convertirMoneda(moneda1, moneda2, cotizaciones);
        return false;
    }
}
