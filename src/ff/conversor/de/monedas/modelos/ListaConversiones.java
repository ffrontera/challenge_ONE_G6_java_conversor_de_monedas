package ff.conversor.de.monedas.modelos;

import java.util.ArrayList;

public record ListaConversiones (ArrayList<Conversion> conversiones) {

    @Override
    public String toString() {
        String salida = "";
        int aux = 1;
        for (Conversion conversion : conversiones) {
            salida +=aux + "- " + conversion.toString() + "\n";
            aux++;
        }
        return salida;
    }

}
