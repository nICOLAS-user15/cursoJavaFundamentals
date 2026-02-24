public record SaudeBemEstar(double valor) implements ValorTributo {
    @Override
    public double calcularValorTributo() {
        return valor * 1.5;
    }

}
