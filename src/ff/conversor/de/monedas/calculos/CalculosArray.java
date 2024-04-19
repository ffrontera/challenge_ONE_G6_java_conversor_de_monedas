package ff.conversor.de.monedas.calculos;

public class CalculosArray {

    public int stringMasLargaArray(String[] array) {
        int largoStringMasLarga = 0;
        int aux;
        for (String string : array) {
            aux = string.length();
            if (aux > largoStringMasLarga)
                largoStringMasLarga = aux;
        }
        return largoStringMasLarga;
    }
}
