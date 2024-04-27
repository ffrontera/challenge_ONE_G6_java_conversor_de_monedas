package ff.conversor.de.monedas.calculos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HoraFechaActual {

    public String horaFechaActual() {
        LocalDateTime horaFechaActual = LocalDateTime.now();
        DateTimeFormatter formatoHoraFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String fechaHoraConFormato = horaFechaActual.format(formatoHoraFecha);
        return fechaHoraConFormato;
    }
}
