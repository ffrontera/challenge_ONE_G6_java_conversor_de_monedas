package ff.conversor.de.monedas.modelos;

import java.util.HashMap;
import java.util.Map;

public class Moneda {
    private Map<String, Float> conversion_rates = new HashMap<>();

    public float getMoneda(String moneda){
        return this.conversion_rates.get(moneda);
    }

}
