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

    public double calcularCostoBase(){
        return peso * 10.00;
    }

    public double calcularCostoFinal() {
        return calcularCostoBase();
    }

    protected String obtenerCargosAdd() {
        return "Sin cargos adicionales.";
    }

    public void mostrarResumen() {
        System.out.println("----- Resumen del Envío -----");
        System.out.println("Código: " + codigo);
        System.out.println("Destinatario: " + destinatario);
        System.out.printf("Costo final: Q%.2f%n", calcularCostoFinal());
        System.out.println("------------------------------");
    }

    public void mostrarResumen(boolean detalle) {
        if (!detalle) {
            mostrarResumen();
            return;
        }

        System.out.println("----- Resumen detallado del Envío -----");
        System.out.println("Código: " + codigo);
        System.out.println("Destinatario: " + destinatario);
        System.out.printf("Peso del paquete: %.2f kg%n", peso);
        System.out.printf("Costo base: Q%.2f%n", calcularCostoBase());
        System.out.println(obtenerCargosAdd());
        System.out.printf("Costo final: Q%.2f%n", calcularCostoFinal());
        System.out.println("----------------------------------------");
    }

}
