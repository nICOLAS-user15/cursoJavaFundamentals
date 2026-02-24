public record Cultura(double valor) implements ValorTributo {
    @Override
    public double calcularValorTributo() {
        return valor * 4.0;
    }

}
