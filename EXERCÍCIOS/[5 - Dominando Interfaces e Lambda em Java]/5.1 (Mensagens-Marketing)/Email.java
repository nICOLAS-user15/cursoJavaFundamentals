public record Email(String mensagem) implements Mensagem {
    @Override
    public String getMensagem() {
        System.out.println("Escreva sua mensagem de email: ");
        return mensagem;
    }

}
