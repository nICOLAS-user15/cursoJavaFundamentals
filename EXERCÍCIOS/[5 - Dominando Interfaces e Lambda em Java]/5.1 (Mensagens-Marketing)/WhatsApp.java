public record WhatsApp(String mensagem) implements Mensagem {
    @Override
    public String getMensagem() {
        System.out.println("Escreva sua mensagem de WhatsApp: ");
        return mensagem;
    }

}
