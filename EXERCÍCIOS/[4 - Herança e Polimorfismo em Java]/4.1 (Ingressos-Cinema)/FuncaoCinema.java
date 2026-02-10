import java.util.Scanner;

public class FuncaoCinema extends IngressoCinema{
    private static final Scanner scanner = new Scanner(System.in);

    public void NomeFilme() {
        String nomeFilmeString;
        do {
            System.out.println("Informe o nome do filme: ");
            nomeFilmeString = scanner.nextLine();
            if (nomeFilmeString == null || nomeFilmeString.trim().isEmpty()) {
                System.out.println("Nome do filme não pode ser vazio. Tente novamente.");
            }
        } while (nomeFilmeString == null || nomeFilmeString.trim().isEmpty());
        setNomeFilme(nomeFilmeString);
        System.out.println("Você escolheu assistir " + getNomeFilme() + ".");
        return;
    }

    public void DubladoLegendado() {
        while (getNomeFilme() == null || getNomeFilme().trim().isEmpty()) {
        NomeFilme();
        }
        String option;
        do {
            System.out.println("\nDeseja assistir " + getNomeFilme() + " dublado ou legendado?: ");
            option = scanner.nextLine();
            if (option == null || option.trim().isEmpty()) {
                System.out.println("Opção não pode ser vazia. Tente novamente.");
                continue;  
            }
            switch (option.toLowerCase()) {  
                case "dublado": {
                    System.out.println("Você escolheu assistir " + getNomeFilme() + " dublado.");
                    setDublado(option);  
                    break;
                }
                case "legendado": {
                    System.out.println("Você escolheu assistir " + getNomeFilme() + " legendado.");
                    setLegendado(option);  
                    break;
                }
                default: {
                    System.out.println("Opção inválida. Escolha assistir dublado ou legendado para continuar.");
                    option = null;  
                    break;
                }
            }
        } while (option == null || (!option.equalsIgnoreCase("dublado") && !option.equalsIgnoreCase("legendado")));
    }

    public void ValorIngresso() {
        System.out.println("\nInforme o valor do ingresso: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("O valor do ingresso não pode ser vazio ou inválido.");
            scanner.nextLine(); 
            return;
        }
        double valorIngresso = scanner.nextDouble();
        if (valorIngresso <= 0) {
            System.out.println("O valor do ingresso deve ser maior que 0.");
            return;
        }
        setValor(valorIngresso);
        System.out.println("O ingresso custa R$ " + String.format("%.2f", getValor()) + ".");
        return;
    }

    public void TipoIngresso() {
        int option;
        do {
            System.out.println("\nSelecione o tipo de ingresso: ");
            System.out.println("1 - Meia Entrada");
            System.out.println("2 - Ingresso Família");
            option = scanner.nextInt();
            switch (option) {
                case 1: meiaEntrada();
                    return; 
                case 2: IngressoFamilia();
                    return;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (option != 1 && option != 2); 
    }

    public void meiaEntrada(){
        double valorMeiaEntrada = getValor() / 2;
        System.out.println("O valor do ingresso meia entrada é de "  + String.format("%.2f", valorMeiaEntrada) + ".");
    }

    public void IngressoFamilia(){
        System.out.println("Informe quantos ingressos deseja comprar: ");
        var quantidadeIngressos = scanner.nextInt();
        double ingressoFamilia = quantidadeIngressos * getValor();
        System.out.println("Você comprou " + quantidadeIngressos + " ingressos família, totalizando R$" + ingressoFamilia);
    }
}


