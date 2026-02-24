public record Vestuario(double valor) implements ValorTributo {
    @Override
    public double calcularValorTributo() {
        return valor * 2.5;
    }

}
