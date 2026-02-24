public record WhatsApp(String mensagem) implements Mensagem {
    @Override
    public String getMensagem() {
        return mensagem;
    }
}

