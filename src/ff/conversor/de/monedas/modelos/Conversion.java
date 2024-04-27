package ff.conversor.de.monedas.modelos;

public class Conversion {

    private String monedaEntrada;
    private double valorEntrada;
    private String monedaSalida;
    private String tasaConversion;
    private String valorSalida;
    private String fechaHoraConversion;

    public Conversion(String monedaEntrada, double valorEntrada, String monedaSalida, String valorSalida, String fechaHoraConversion, String tasaConversion) {
        this.monedaEntrada = monedaEntrada;
        this.valorEntrada = valorEntrada;
        this.monedaSalida = monedaSalida;
        this.tasaConversion = tasaConversion;
        this.valorSalida = valorSalida;
        this.fechaHoraConversion = fechaHoraConversion;
    }

    @Override
    public String toString() {
        return  "Moneda origen = " + monedaEntrada +
                ", valor origen = " + valorEntrada +
                ", Moneda salida = " + monedaSalida +
                ", tasa de cambio = " + tasaConversion +
                ", valor salida = " + valorSalida +
                ", fecha y hora = " + fechaHoraConversion;
    }
}
