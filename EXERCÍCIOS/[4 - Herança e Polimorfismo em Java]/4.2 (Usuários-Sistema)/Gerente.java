import java.util.Scanner;

public class Gerente extends Empregado {
    private static final Scanner scanner = new Scanner(System.in);
    private boolean logado = false;  
    
    public Gerente() {
        this.isAdmin = true;
    }

    public void cadastrarGerente(Gerente gerente) {
        System.out.println("=====CADASTRO DE GERENTE=====");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        gerente.setNome(nome);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        gerente.setEmail(email);
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        gerente.setSenha(senha);
        System.out.println("Gerente " + getNome() + " cadastrado com sucesso!\n");
        menuGerente();
    }

    public void realizarLoginGerente() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        if (email.equals(this.email) && senha.equals(this.senha)) {
            this.logado = true;  
            System.out.println("Login de " + getNome() + "realizado com sucesso!");
            menuGerente();
        } else {
            System.out.println("Email ou senha incorretos!");
        }
    }

    public void realizarLogoutGerente() {
        if (this.logado) {
            this.logado = false;  
            System.out.println("Logout realizado com sucesso!");
        } else {
            System.out.println("Você não está logado.");
        }
    }

    public void menuGerente(){
        var option = -1;
        do {
            System.out.println("=====MENU DO GERENTE=====");
            System.out.println("Olá getente " + getNome() + ", seja bem vindo!");
            System.out.println("Escolha uma das seguinte operações:");
            System.out.println("1 - Gerar relatório financeiro");
            System.out.println("2 -  Consutar vendas");
            System.out.println("3 - Alterar dados");
            System.out.println("4 -  Alterar Senha");
            System.out.println("0 - SAIR");
            option = scanner.nextInt();
        } while (option != 0);
        switch (option) {
            case 1: gerarRelatorioFinanceiro();
                break;
            case 2: consultarVendas();
                break;
            case 3: alterarDadosGerente();
                break;
            case 4: alterarSenhaGerente();
                break;
            case 0: System.out.println("Você saiu do sistema!");
            default: System.out.println("Opção Inválida!");
                break;
        }
    }


    public void gerarRelatorioFinanceiro() {
        double receitaTotal = 5000.0;  
        double custos = receitaTotal * 0.3;  
        double lucro = receitaTotal - custos;

        System.out.println("=====RELATÓRIO FINANCEIRO=====");
        System.out.println("Receita Total: R$ " + receitaTotal);
        System.out.println("Custos: R$ " + custos);
        System.out.println("Lucro: R$ " + lucro);
        System.out.println("Relatório gerado com sucesso!");
        return;
    }

    public void consultarVendas() {
        Vendedor vendedor =  new Vendedor();
        int totalVendas = 5;
        System.out.println("Consultando vendas...");
        System.out.println("Total de vendas realizadas: " + totalVendas);
        if (totalVendas == 0) {
            System.out.println("Nenhuma venda registrada ainda.");
        }
        return;
    }

    public void alterarDadosGerente() {
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        this.setNome(nome);
        System.out.print("Novo Email: ");
        String email = scanner.nextLine();
        this.setEmail(email);
        System.out.println("Dados alterados com sucesso!");
        return;
    }

    public void alterarSenhaGerente() {
        System.out.print("Nova Senha: ");
        String senha = scanner.nextLine();
        this.setSenha(senha);
        System.out.println("Senha alterada com sucesso!");
        return;
    }
}