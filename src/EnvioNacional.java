public class EnvioNacional extends Envio {
    private String deptoDestino;
    private double distKm;

    private static final double cost_Km = 0.50;

    public EnvioNacional(String codigo,
                         String destinatario,
                         double peso,
                         String departamentoDestino,
                         double distanciaKm) {
        super(codigo, destinatario, peso);
        this.deptoDestino = departamentoDestino;
        this.distKm = distanciaKm;
    }

    public String getDepartamentoDestino() {
        return deptoDestino;
    }

    public double getDistanciaKm() {
        return distKm;
    }

    public double calcularCargoPorDistancia() {
        return distKm * cost_Km;
    }

    @Override
    public double calcularCostoFinal() {
        return calcularCostoBase() + calcularCargoPorDistancia();
    }

    @Override
    protected String obtenerCargosAdd() {
        return String.format("Departamento de destino: %s%nDistancia: %.2f km%nCargo por distancia: Q%.2f",
                deptoDestino, distKm, calcularCargoPorDistancia());
    }

}
