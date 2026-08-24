public class Envio {

    private String codigo;
    private String destinatario;
    private double peso;

    public Envio(String codigo, String destinatario, double peso){
        this.codigo =  codigo;
        this.destinatario = destinatario;
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public double getPeso() {
        return peso;
    }


}
