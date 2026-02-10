import java.util.Scanner;

public final class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Empregado empregado = new Empregado();
    private static final Gerente gerente = new Gerente();
    private static final Vendedor vendedor = new Vendedor();
    private static final Atendente atendente = new Atendente();

    public static void main(String[] args) {
        var option = -1;
        do{
            System.out.println("=====SISTEMA EMPRESA=====");
            System.out.println("Informe seu cargo na empresa:");
            System.out.println("1 - Gerente");
            System.out.println("2 - Vendedor");
            System.out.println("3 - Atendente");
            System.out.println("0 - SAIR");
            option = scanner.nextInt();
            scanner.nextLine();
        }   while(option != 0);
        switch (option) {
            case 1: contaGerente();
                break;
            case 2: contaVendedor();
                break;
            case 3: contaAtendente();
                break;
            case 0: System.out.println("Você saiu do sistema!");
                break;
            default: System.out.println("Opção inválida!");
                break;
        }
    }

    public static void contaGerente() {
        while (true) {
            System.out.println("Olá Gerente, escolha as opções:");
            System.out.println("1 - Cadastrar Conta");
            System.out.println("2 - Fazer Login");
            System.out.println("0 - SAIR");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 0) return;
            if (option == 1) gerente.cadastrarGerente(gerente);
            else if (option == 2) gerente.realizarLoginGerente();
            else System.out.println("Opção inválida!");
            return;
        }
    }
    
    public static void contaVendedor(){
         while (true) {
            System.out.println("Olá Vendedor, escolha as opções:");
            System.out.println("1 - Cadastrar Conta");
            System.out.println("2 - Fazer Login");
            System.out.println("0 - SAIR");
            scanner.nextLine();
            int option = scanner.nextInt();
            if (option == 0) return;
            if (option == 1) vendedor.cadastrarVendedor(empregado);
            else if (option == 2) vendedor.realizarLoginVendedor();
            else System.out.println("Opção inválida!");
            return;
        }
    }
    
    public static void contaAtendente(){
         while (true) {
            System.out.println("Olá Atendente, escolha as opções:");
            System.out.println("1 - Cadastrar Conta");
            System.out.println("2 - Fazer Login");
            System.out.println("0 - SAIR");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 0) return;
            if (option == 1) atendente.cadastrarAtendente(empregado);
            else if (option == 2) atendente.realizarLoginAtendente();
            else System.out.println("Opção inválida!");
            return;
        }
    }
}
