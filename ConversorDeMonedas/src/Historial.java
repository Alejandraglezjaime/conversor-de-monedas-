import java.util.ArrayList;
import java.util.List;

public class Historial {

    private List<String> historial = new ArrayList<>();
    public int contador=1;
    public void agregarHistorial (double cantidad, String tipoOperacion, String codigo, double monto ) {


        if(tipoOperacion.equals("CAD")){
            historial.add(" ⚝ "+contador +" .- "+ String.format("%.2f", cantidad) + " [" + codigo + "] a " + String.format("%.2f", monto) + " [USD]");
            contador++;
        } else {
            historial.add(" ⚝ "+contador+" .- " + String.format("%.2f", cantidad) + " [USD] a " + String.format("%.2f", monto) + " [" + codigo + "]");
            contador++;
        }



    }

    public List<String> getHistorial() {
        return historial;
    }

    public int totalOperaciones() {
        return historial.size();
    }
}
