public record Email(String mensagem) implements Mensagem {
    @Override
    public String getMensagem() {
        return mensagem;
    }
}

