public class Moneda {

    private String codigo;
    private Double conversionMoneda;

    /*Constructor*/
    public Moneda(String codigo, Double conversionMoneda) {
        this.codigo = codigo;
        this.conversionMoneda = conversionMoneda;
    }
    /*Gets*/
    public String getCodigo() {
        return codigo;
    }

    public Double getValorConversion() {
        return conversionMoneda;
    }


}
