package ff.conversor.de.monedas.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

import java.util.Scanner;

public class ModificarArchivo {

    private Gson gson = new Gson();

    public void guardarConversion(Conversion conversion) throws IOException {
        String json = this.leerArchivo();
        ListaConversiones listaConversiones = gson.fromJson(json, ListaConversiones.class);


        if(listaConversiones.conversiones().size() == 10)
            listaConversiones.conversiones().remove(0);

        listaConversiones.conversiones().add(conversion);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("conversiones.json");
        escritura.write(gson.toJson(listaConversiones));
        escritura.close();
    }

    public String leerArchivo() throws FileNotFoundException {
        File archivo = new File("conversiones.json");
        String json = "";
        try {
            Scanner leer = new Scanner(archivo);
            while (leer.hasNextLine()) {
                json += leer.nextLine();
            }
            leer.close();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return json;
    }
}
