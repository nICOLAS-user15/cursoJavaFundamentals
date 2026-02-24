import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        var option = -1;
        Mensagem mensagem = null;
        System.out.println("-----BEM VINDO AO GERADOR DE MENSAGENS DE MARKETING-----");
        System.out.println("Escreva uma mensagem de marketing para o seu público-alvo: ");
        var mensagemTexto = scanner.nextLine();
        if (mensagemTexto.isBlank()) {
            System.out.println("A mensagem não pode ser vazia. Tente novamente.");
        }
        do{
            System.out.println("Escolha o canal de comunicação:");
            System.out.println("1 - SMS");
            System.out.println("2 - Email");
            System.out.println("3 - Redes Sociais");
            System.out.println("4 - WhatsApp");
            System.out.println("0 - SAIR");
            option = scanner.nextInt();
            scanner.nextLine(); 
            switch (option) {
                case 1: mensagem = mensagemSMS(mensagemTexto); break;
                case 2: mensagem = mensagemEmail(mensagemTexto); break;
                case 3: mensagem = mensagemRedesSociais(mensagemTexto); break;
                case 4: mensagem = mensagemWhatsApp(mensagemTexto); break;
                case 0: System.out.println("VOCÊ SAIU DO PROGRAMA!"); break;
                default: System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE."); break;
            }
        } while (option != 0);
        scanner.close();
    }

    public static Mensagem mensagemSMS(String mensagem) {
        System.out.println("Mensagem: " + mensagem + " enviada por SMS.");
        return new SMS(mensagem);
    }

    public static Mensagem mensagemEmail(String mensagem) {
        System.out.println("Mensagem: " + mensagem + " enviada por Email.");
        return new Email(mensagem);
    }

    public static Mensagem mensagemRedesSociais(String mensagem) {
        System.out.println("Mensagem: " + mensagem + " enviada por Redes Sociais.");
        return new RedesSociais(mensagem);
    }

    public static Mensagem mensagemWhatsApp(String mensagem) {
        System.out.println("Mensagem: " + mensagem + " enviada por WhatsApp.");
        return new WhatsApp(mensagem);
    }
}
