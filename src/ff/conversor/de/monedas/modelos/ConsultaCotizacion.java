package ff.conversor.de.monedas.modelos;

import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaCotizacion {

    public float obtenerCotizacion(String moneda) {

        URI urlEnchange = URI.create("https://v6.exchangerate-api.com/v6/e49abfd86fe7a9c0782eec5a/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlEnchange)
                .build();

        try {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            String json = response.body();

            Moneda cotizaciones = gson.fromJson(json, Moneda.class);

            return cotizaciones.getMoneda(moneda);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return 0;
    }
}
