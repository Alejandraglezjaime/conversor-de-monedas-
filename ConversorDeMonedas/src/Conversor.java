import Excepciones.Excepcion;

public class Conversor {


    public void convertirMoneda(Moneda moneda, String tipoOperacion, double cantidad, Historial historial) {

        double monto;
        //CONVIERTE UNA MONEDA A DOLARES
        if(tipoOperacion.equals("CAD")){
            monto =  cantidad / moneda.getValorConversion();
            String mensaje = cantidad + " [" +moneda.getCodigo() + "] equivalen a " + "%.2f" + " [USD]";
            System.out.println(String.format(mensaje, monto));
        //CONVIERTE DOLARES A DIFERENTE MONEDA
        } else if(tipoOperacion.equals("USD")){
            monto =  cantidad * moneda.getValorConversion();
            String mensaje = cantidad + " [USD] "+"equivalen a "+ "%.2f"+ " [" + moneda.getCodigo()+"]";
            System.out.println(String.format(mensaje, monto));
        } else {
            throw new Excepcion("Operación invalida");
        }

        historial.agregarHistorial(cantidad, tipoOperacion, moneda.getCodigo(), monto);

    }

}
