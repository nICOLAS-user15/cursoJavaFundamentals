public record RedesSociais(String mensagem) implements Mensagem {
    @Override
    public String getMensagem() {
        return mensagem;
    }
}

