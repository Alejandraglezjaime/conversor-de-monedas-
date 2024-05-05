# $ CONVERSOR DE MONEDAS CON BASE AL DOLAR $
![Imagen dolar](https://github.com/Alejandraglezjaime/conversor-de-monedas-/blob/master/ConversorDeMonedas/imagenes/dinero.jpg?raw=true)

## Descripción del proyecto 

Vivimos en un mundo globalizado y conocer la cotización de diferentes monedas es algo muy importante y valioso para nuestro día a día.
Esta proyecto fué creado para el Challenge en ONE (Oracle Next Eucation) en la formación de Java orientado a objetos G6 - ONE 2024.

En este proyecto encontraras:

- [x] **API de tasas de cambio**
- [x] **La clase HttpClient** para realizar solicitudes a la API de tasas de cambio y obtener datos esenciales.  El uso de HttpClient en Java facilita la conexión y la obtención de respuestas de manera eficiente. Además, proporciona una base sólida para realizar operaciones HTTP de manera más estructurada y versátil.
- [x] **La clase HttpRequest** para configurar y personalizar nuestras solicitudes a la API de tasas de cambio. La clase HttpRequest en Java nos brinda un control detallado sobre los parámetros de nuestras solicitudes, lo que resulta esencial para adaptar la consulta a nuestras necesidades específicas.
- [x] **La interfaz HttpResponse** para gestionar las respuestas recibidas de la API. La interfaz HttpResponse en Java ofrece una estructura que permite acceder y analizar los diferentes elementos de una respuesta HTTP.
- [x] **Análisis de las respuestas en formato JSON**
- [x] **Conversión de las monedas**
- [x] **Interacción con el usuario**

### Extras 

- [x] **Historial de Conversiones**. Agrega la capacidad de mostrar el historial de las últimas conversiones realizadas, brindando a los usuarios una visión completa de sus actividades.
- [ ] **Soporte para Más Monedas**. Amplía la lista de monedas disponibles para la elección, permitiendo a los usuarios convertir entre una variedad aún mayor de opciones monetarias.
- [ ] **Registros con Marca de Tiempo** Utiliza las funciones de la biblioteca java.time para crear registros que registren las conversiones realizadas, incluyendo información sobre qué monedas se convirtieron y en qué momento.

Encontraras el proyecto en la carpeta _conversorDeMonedas_
## Importa la biblioteca Gson en IntelliJ

    1.- Dentro de file selecciona "Project settings"  y posterior la opcióm "Modules"
    
    2.- En la ventana que se abre, ve a la pestaña "Dependencies".

    3.- Haz clic en el signo "+" en la esquina inferior izquierda y elige "JARs or directories".
    
    4.- Busca "gson" en el cuadro de búsqueda.
    
    5.- Selecciona la versión de Gson que desees utilizar.
    
    6.- Haz clic en "OK" para cerrar la ventana.

Ahora, la biblioteca Gson está agregada a tu proyecto y puedes comenzar a utilizarla importando sus clases en tus archivos Java.

_NOTA: El archivo JSon lo dejo dentro de la carpeta conversor de monedas_

![Importacion Json](https://github.com/Alejandraglezjaime/conversor-de-monedas-/blob/master/ConversorDeMonedas/imagenes/imporacion%20json.png?raw=true)

## RESULTADOS

Al ejecutar el programa podemos observar un menú despegable de las opciones que podemos escoger para convertir las monedas, entre ellas observamos el dolar, peso argentino, real brasileño, peso chileno, peso colombiano, peso mexicano, además de poder visualizar en la consola el historial de conversiones realizadas y el total de operaciones, además de ocupar un bucle que se ejecutara hasta que el usuario tecle la opcion _salir_, si el usuario teclea cualquier número que no esta en nuestra lista voolvera a mandar el menú despegable.

![Imagen menu](https://github.com/Alejandraglezjaime/conversor-de-monedas-/blob/master/ConversorDeMonedas/imagenes/imagenInicio.jpg?raw=true)

A continuación observamos el funcionamiento de conversión, cuando el usuario elige convertir de dólar a peso argentino, de peso mexicano a dólar, saber el total de conversiones realizadas, y observar el historial.
![Imagen dolar a ars](https://github.com/Alejandraglezjaime/conversor-de-monedas-/blob/master/ConversorDeMonedas/imagenes/evidencia1.jpg?raw=true) 
![Imagen mxn a usdu](https://github.com/Alejandraglezjaime/conversor-de-monedas-/blob/master/ConversorDeMonedas/imagenes/evidencia2.jpg?raw=true) 
![Imagen total operaciones](https://github.com/Alejandraglezjaime/conversor-de-monedas-/blob/master/ConversorDeMonedas/imagenes/evidencia3.jpg?raw=true) 
![Imagen historial](https://github.com/Alejandraglezjaime/conversor-de-monedas-/blob/master/ConversorDeMonedas/imagenes/historialConversiones.jpg?raw=true)

### EXCEPCIONES
En nuestro código, podemos observar el manejo de la excepción _**NumberFormatException**_ que se activará cuando el usuario ingrese datos de tipo String, como "UNO", en lugar de números válidos. Además, en muchos países, en lugar de utilizar el punto decimal para separar la parte entera de la fraccionaria en números flotantes, se utiliza la coma. Por lo tanto, si el usuario ingresa "8,36" en lugar de "8.36", también activará esta excepción, ya que solo se espera la entrada de números enteros o flotantes.   

![excepcion NumberFormatException](https://github.com/Alejandraglezjaime/conversor-de-monedas-/blob/master/ConversorDeMonedas/imagenes/errorIngresoNumero.jpg?raw=true)

En el código, se implemento una lista que contiene los datos a buscar en la API. Si alguno de los datos en esta lista está incorrecto o no coincide con los valores esperados, se activará la excepción _**RuntimeException.**_ esta excepción se utilizará para notificar al usuario que no se ha encontrado la tasa de conversión para una moneda específica.

En caso de que se active la excepción RuntimeException, se enviará el siguiente error:

![excepcion RuntimeException](https://github.com/Alejandraglezjaime/conversor-de-monedas-/blob/master/ConversorDeMonedas/imagenes/errorIngresoDatos.jpg?raw=true)

Este mensaje indicará al usuario que la tasa de conversión para una moneda específica no se pudo encontrar, y especificará cuál es esa moneda. El código no permitirá continuar con la ejecución hasta que se corrija el dato incorrecto en la lista de búsqueda.

### Aplicación JSON 

Al finalizar la ejecución del programa, se generarán dos archivos en formato JSON:

#### Archivo de Tasas de Conversión

El primer archivo contiene la información de las tasas de conversión. Este archivo presenta los códigos de moneda y sus respectivos valores de conversión.

![archivo conversion](https://github.com/Alejandraglezjaime/conversor-de-monedas-/blob/master/ConversorDeMonedas/imagenes/JsonConversiones.jpg?raw=true)

#### Archivo de Historial de Conversiones

El segundo archivo JSON muestra un registro del historial de conversiones realizadas durante la ejecución del programa. Cada vez que se ejecuta el programa, este archivo se sobrescribe con los datos actualizados del historial, además de guardar el total de conversiones realizadas.

![archivo historial](https://github.com/Alejandraglezjaime/conversor-de-monedas-/blob/master/ConversorDeMonedas/imagenes/JsonHistorial.jpg?raw=true)

Estos archivos proporcionan una visión detallada de las tasas de conversión actuales y un registro completo de las conversiones realizadas en cada ejecución del programa.

## AUTOR
© Alejandra Gonzalez 

![imagen salida](https://github.com/Alejandraglezjaime/conversor-de-monedas-/blob/master/ConversorDeMonedas/imagenes/finPrograma.jpg?raw=true)
