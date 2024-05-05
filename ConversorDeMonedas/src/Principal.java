import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {

        API llamada = new API();
        Historial historial = new Historial();
        Scanner sc = new Scanner(System.in);
        Conversor conversor = new Conversor();
        List<Moneda> monedas = new ArrayList<>();
        monedas = llamada.obtenerMonedas("ARS", "BRL", "COP", "CLP", "MXN");
        String opcionElegida;


        System.out.println("""
                
                      ♡ ＄ Bienvenido al conversor de monedas. ＄ ♡
                Esta plataforma le permite convertir el valor de las monedas.
                
                """);
        String mensajePrincipal = """
                *********************************************
                Elija la opción deseada:
                
                1) Dólar a peso argentino
                2) Peso argentino a dólar
                3) Dólar a real brasileño
                4) Real brasileño a dólar
                5) Dólar a peso chileno
                6) Peso chileno a dólar
                7) Dólar a peso colombiano
                8) Peso colombiano a dólar
                9) Dólar a peso mexicano
                10) Peso mexicano a dólar
                11) Ver historial de conversiones
                12) Total de operaciones
                13) Salir
                *********************************************""";

        String messege = "Ingrese el valor que desea convertir: ";

        String despedida = """
                
                ♡ ¡Espero que hayas disfrutado del programa! Vuelve pronto. ♡
                       Creado por : Arleth Alejandra Gonzalez Jaime
                
                """;


        while(true) {
            System.out.println(mensajePrincipal);
            opcionElegida = sc.next();



            try {
                int opcion = Integer.valueOf(opcionElegida);
                //El usuario teclea una opción que no esta dentro de la lista, por lo tanto, vuelve a mandar la lista para que verifique la elección

                if (opcion > 13 || opcion < 1) {
                    System.out.println("Opción invalida, verifica la marcación.");
                }
                //Historial de conversiones
                else if(opcion == 11){
                    if(historial.getHistorial().isEmpty()) { //Si la lista historial esta vacía
                        System.out.println("\nLo siento aún no ha realizado ninguna conversión :(");
                    } else {
                        System.out.println("\nHistorial de conversiones : ");

                        for (String elemento : historial.getHistorial()) {
                            System.out.println(elemento);
                        }
                        System.out.println("\n");
                    }
                } //El usuario desea salir del programa
                else if (opcion == 13) {
                    System.out.println(despedida);
                    break;
                } else if (opcion == 12) {
                    if(historial.totalOperaciones() == 0 ){
                        System.out.println("Aun no cuenta con operaciones ");
                    } else {
                    System.out.println("El total de operaciones es : "+historial.totalOperaciones());}
                }

                // Si la opción es par, significa que se elige una moneda distinta al dólar
                else if (opcion % 2 == 0) {
                    // Se calcula el índice en la lista de monedas para obtener la moneda correspondiente.
                    Moneda moneda = monedas.get((opcion / 2) - 1);
                    System.out.println(messege);
                    double cantidad = sc.nextDouble();
                    conversor.convertirMoneda(moneda, "CAD", cantidad, historial);

                }  else {
                    // Se calcula el índice en la lista de monedas para obtener la moneda correspondiente.
                    Moneda moneda = monedas.get((opcion - 1) / 2);
                    System.out.println(messege);
                    double cantidad = sc.nextDouble();
                    conversor.convertirMoneda(moneda, "USD", cantidad, historial);

                }


                GeneradorHistorial generador = new GeneradorHistorial();
                generador.guardarJson(historial);

            } catch (NumberFormatException e){
                System.out.println("""
                                    Número no encontrado, verifica tu marcación. 
                                        * Solo se permiten números 
                                        * El numero puede ser entero (ejemplo: 5) o con punto decimal (ejemplo 6.63)""");
            }




        }


        // Generar el JSON utilizando la clase GeneradorArchivo
        String json = GeneradorArchivo.generarJson(monedas);

        // Escribir el JSON en un archivo
        String rutaArchivoJson = "valoresMonedas.json";
        try (FileWriter writer = new FileWriter(rutaArchivoJson)) {
            writer.write(json);
        }

        System.out.println("Archivo JSON generado correctamente.");



    }

}
