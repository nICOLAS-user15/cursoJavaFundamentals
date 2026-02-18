import java.util.Scanner;

public final class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Gerente gerente = new Gerente();
    private static final Vendedor vendedor = new Vendedor();
    private static final Atendente atendente = new Atendente();

    public static void main(String[] args) {
        var option = -1;
        do {
            System.out.println("\n=====MENU PRINCIPAL DA EMPRESA=====");
            System.out.println("1 - Gerente");
            System.out.println("2 - Vendedor");
            System.out.println("3 - Atendente");
            System.out.println("0 - SAIR");
            System.out.println("Informe seu cargo na empresa:");
            
            try {
                option = scanner.nextInt();
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite apenas números.");
                scanner.nextLine(); 
                continue;
            }
            
            switch (option) {
                case 1: contaGerente(); break;
                case 2: contaVendedor(); break;
                case 3: contaAtendente(); break;
                case 0: 
                    System.out.println("\nEncerrando sistema... Até logo!");
                    scanner.close();
                    return;
                default: System.out.println("Opção inválida! Tente novamente.");
            }
        } while (option != 0); 
    }

    public static void contaGerente() {
        while (true) {
            System.out.println("\n===== ÁREA DO GERENTE =====");
            System.out.println("1 - Cadastrar Conta");
            System.out.println("2 - Fazer Login");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            
            int option;
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada inválida!");
                scanner.nextLine();
                continue;
            }
            
            switch (option) {
                case 1: gerente.cadastrarGerente(gerente); return;
                case 2: gerente.realizarLoginGerente(); return;
                case 0: return;
                default: System.out.println("Opção inválida!");
            }
        }
    }
    
    public static void contaVendedor() {
        while (true) {
            System.out.println("\n===== ÁREA DO VENDEDOR =====");
            System.out.println("1 - Cadastrar Conta");
            System.out.println("2 - Fazer Login");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            
            int option;
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada inválida!");
                scanner.nextLine();
                continue;
            }
            
            switch (option) {
                case 1: vendedor.cadastrarVendedor(vendedor); return;
                case 2: vendedor.realizarLoginVendedor(); return;
                case 0: return;
                default: System.out.println("Opção inválida!");
            }
        }
    }
    
    public static void contaAtendente() {
        while (true) {
            System.out.println("\n===== ÁREA DO ATENDENTE =====");
            System.out.println("1 - Cadastrar Conta");
            System.out.println("2 - Fazer Login");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            
            int option;
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada inválida!");
                scanner.nextLine();
                continue;
            }
            
            switch (option) {
                case 1: atendente.cadastrarAtendente(atendente); return;
                case 2: atendente.realizarLoginAtendente(); return;
                case 0: return;
                default: System.out.println("Opção inválida!");
            }
        }
    }
}
