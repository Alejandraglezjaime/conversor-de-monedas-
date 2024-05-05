import java.util.List;

public class GeneradorArchivo {

    public static String generarJson(List<Moneda> monedas) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");

        for (Moneda moneda : monedas) {
            jsonBuilder.append("  {\n");
            jsonBuilder.append("    \"codigo\": \"").append(moneda.getCodigo()).append("\",\n");
            jsonBuilder.append("    \"conversionMoneda\": ").append(moneda.getValorConversion()).append("\n");
            jsonBuilder.append("  },\n");
        }

        // Eliminamos la coma extra al final del último elemento
        if (!monedas.isEmpty()) {
            jsonBuilder.deleteCharAt(jsonBuilder.length() - 2);
        }

        jsonBuilder.append("]\n");

        return jsonBuilder.toString();
    }
}