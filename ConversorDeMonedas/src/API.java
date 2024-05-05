import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class API {

    public List<Moneda> obtenerMonedas(String moneda1, String moneda2, String moneda3, String moneda4, String moneda5) {
        //Se crea una lista vacía llamada tasasDeConversion que almacenará objetos de tipo Moneda. Esta lista se utilizará para almacenar las tasas de conversión obtenidas de la API.
        List<Moneda> tasasDeConversion = new ArrayList<>();
        String direccion = "https://v6.exchangerate-api.com/v6/80af06bcb8558b5db15bc398/latest/USD"; //Dirección de la API de tasas de moneda

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                             .uri(URI.create(direccion))
                             .build();

        try {
            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            System.out.println(response.body());

            //JsonReader lee los datos de la respuesta JSON obtenida de la API.
            JsonReader lectura = new JsonReader(new InputStreamReader(response.body(), "UTF-8"));

            lectura.beginObject(); //Este método indica que vamos a empezar a leer un objeto JSON.
            //.hasNext() lee los elementos que contiene el JSON
            while (lectura.hasNext()) {
                String name = lectura.nextName(); //En cada iteración del bucle, se lee el nombre del siguiente elemento dentro del objeto JSON
                if (name.equals("conversion_rates")) {
                    lectura.beginObject(); //Este método indica que vamos a empezar a leer otro objeto JSON, que está contenido dentro del objeto "conversion_rates".
                    while (lectura.hasNext()) {
                        String valor = lectura.nextName();
                        if (valor.equals(moneda1)) {
                            Moneda moneda = new Moneda(valor, lectura.nextDouble());
                            tasasDeConversion.add(moneda);
                        } else if (valor.equals(moneda2)) {
                            Moneda moneda = new Moneda(valor, lectura.nextDouble());
                            tasasDeConversion.add(moneda);
                        } else if (valor.equals(moneda3)) {
                            Moneda moneda = new Moneda(valor, lectura.nextDouble());
                            tasasDeConversion.add(moneda);
                        } else if (valor.equals(moneda4)) {
                            Moneda moneda = new Moneda(valor, lectura.nextDouble());
                            tasasDeConversion.add(moneda);
                        } else if (valor.equals(moneda5)) {
                            Moneda moneda = new Moneda(valor, lectura.nextDouble());
                            tasasDeConversion.add(moneda);
                        }
                        else {
                            lectura.skipValue();
                        }
                    }
                    lectura.endObject();
                    break;
                } else {
                    lectura.skipValue();
                }
            }
            lectura.endObject();


            // Verifica si todas las monedas están presentes en tasasDeConversion en caso contrario mandará una excepción indicando cuál es la moneda no encontrada

                    /*.stream(): Convierte la lista tasasDeConversion en un flujo de elementos
                      .anyMatch(): Este método verifica si algún elemento del flujo coincide con la condición dada.
                          m: Este es el parámetro de la expresión lambda. Representa un elemento del flujo sobre el que se está iterando, en este caso, un objeto de tipo Moneda.
                          ->: Es el operador de la expresión lambda que separa los parámetros de la expresión lambda del cuerpo de la misma.
                          m.getCodigo(): Esto llama al método getCodigo() en el objeto m, que devuelve el código de la moneda representada por ese objeto Moneda.
                          .equals(moneda1): Este es el método de comparación que verifica si el código de la moneda (m.getCodigo()) es igual al código de la moneda especificada (moneda1).
                          (lambda m -> m.getCodigo().equals(moneda1)) se lee como "para cada Moneda en el flujo, verifica si el código de esa moneda es igual al código de moneda1".
                    */

            List<String> monedasNoEncontradas = new ArrayList<>();
            if (!tasasDeConversion.stream().anyMatch(m -> m.getCodigo().equals(moneda1))) {
                monedasNoEncontradas.add(moneda1);
            }
            if (!tasasDeConversion.stream().anyMatch(m -> m.getCodigo().equals(moneda2))) {
                monedasNoEncontradas.add(moneda2);
            }
            if (!tasasDeConversion.stream().anyMatch(m -> m.getCodigo().equals(moneda3))) {
                monedasNoEncontradas.add(moneda3);
            }
            if (!tasasDeConversion.stream().anyMatch(m -> m.getCodigo().equals(moneda4))) {
                monedasNoEncontradas.add(moneda4);
            }
            if (!tasasDeConversion.stream().anyMatch(m -> m.getCodigo().equals(moneda5))) {
                monedasNoEncontradas.add(moneda5);
            }

            //Si la lista es diferente a vacío, imprimirá la lista de las monedas no encontradas
            if (!monedasNoEncontradas.isEmpty()) {
                throw new RuntimeException("No se encontraron tasas de conversión para las siguientes monedas: " + monedasNoEncontradas +" verifique su escritura");            }

        } catch (IOException e) {
            throw new RuntimeException("Error al realizar la solicitud HTTP: " + e.getMessage());
        } catch (JsonParseException e) {
            throw new RuntimeException("Error al analizar la respuesta JSON: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException("Error durante la ejecución de la solicitud HTTP: " + e.getMessage());
        }

        return tasasDeConversion;
    }
}
