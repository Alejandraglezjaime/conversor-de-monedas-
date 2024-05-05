import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorHistorial {

    public void guardarJson(Historial historial) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("historial.json");

        // Creamos un objeto JSON personalizado que contenga tanto el historial como la longitud
        // de la lista historial
        HistorialJson historialJson = new HistorialJson();
        historialJson.setHistorial(historial.getHistorial());
        historialJson.setcantidadConversiones(historial.getHistorial().size());

        escritura.write(gson.toJson(historialJson));
        escritura.close();
    }

    class HistorialJson {
        private List<String> historial;
        private int cantidadConversiones;

        public List<String> getHistorial() {
            return historial;
        }

        public void setHistorial(List<String> historial) {
            this.historial = historial;
        }

        public int getcantidadConversiones() {
            return cantidadConversiones;
        }

        public void setcantidadConversiones(int cantidadConversiones) {
            this.cantidadConversiones = cantidadConversiones;
        }
    }

}