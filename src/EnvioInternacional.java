public class EnvioInternacional extends Envio {
    private String paisDestino;
    private static final double cargoGestion= 75.00;
    private static final double porcentajeRecargo = 0.12;

    public EnvioInternacional(
            String codigo,
            String destinatario,
            double peso,
            String paisDestino) {
        super(codigo, destinatario, peso);
        this.paisDestino = paisDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public double getCargoGestion() {
        return cargoGestion;
    }

    public double calcularRecargo() {
        return calcularCostoBase() * porcentajeRecargo;
    }

    @Override
    public double calcularCostoFinal() {
        return calcularCostoBase() + cargoGestion + calcularRecargo();
    }

    @Override
    protected String obtenerCargosAdd() {
        return String.format("PaÃ­s de destino: %s%nCargo de gestiÃ³n internacional: Q%.2f%nRecargo del 12%%: Q%.2f",
                paisDestino, cargoGestion, calcularRecargo());
    }
}
