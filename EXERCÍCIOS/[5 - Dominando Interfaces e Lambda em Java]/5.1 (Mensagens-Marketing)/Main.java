import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        var option = -1;
        System.out.println("-----BEM VINDO AO GERADOR DE MENSAGENS DE MARKETING-----");
        System.out.println("Escreva uma mensagem de marketing para o seu público-alvo: ");
        var mensagem = scanner.nextLine();
        if (mensagem.isBlank()) {
            System.out.println("A mensagem não pode ser vazia. Tente novamente.");
        }
        do{
            System.out.println("Escolha o canal de comunicação:");
            System.out.println("1 - Email");
            System.out.println("2 - SMS");
            System.out.println("3 - Redes Sociais");
            System.out.println("4 - WhatsApp");
            System.out.println("0 - SAIR");
            option = scanner.nextInt();
            scanner.nextLine(); 
            switch (option) {
                case 1 -> {
                    var email = new Email(mensagem);
                    System.out.println("Mensagem: " + email.getMensagem() + " enviada por Email.");
                    return;
                }
                case 2 -> {
                    var sms = new SMS(mensagem);
                    System.out.println("Mensagem: " + sms.getMensagem() + " enviada por SMS.");
                    return;
                }
                case 3 -> {
                    var redesSociais = new RedesSociais(mensagem);
                    System.out.println("Mensagem: " + redesSociais.getMensagem() + " enviada por Redes Sociais.");
                    return;
                }
                case 4 -> {
                    var whatsapp = new WhatsApp(mensagem);
                    System.out.println("Mensagem: " + whatsapp.getMensagem() + " enviada por WhatsApp.");
                    return;
                }
                case 0 -> System.out.println("VOCÊ SAIU DO PROGRAMA!"); 
                default -> System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE.");
            }
        } while (option != 0);
}
}
