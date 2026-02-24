public record RedesSociais(String mensagem) implements Mensagem {
    @Override
    public String getMensagem() {
        System.out.println("Escreva sua mensagem de redes sociais: ");
        return mensagem;
    }

}
