public record SMS(String mensagem) implements Mensagem {
    @Override
    public String getMensagem() {
        System.out.println("Escreva sua mensagem de SMS: ");
        return mensagem;
    }

}
