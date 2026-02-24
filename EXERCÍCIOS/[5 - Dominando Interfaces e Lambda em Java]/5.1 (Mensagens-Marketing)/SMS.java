public record SMS(String mensagem) implements Mensagem {
    @Override
    public String getMensagem() {
        return mensagem;
    }
}

