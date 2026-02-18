import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Gerente extends Empregado {
    private static final Scanner scanner = new Scanner(System.in);
    private boolean logado = false;  
    private boolean cadastrado = false;
    private ArrayList<Venda> vendas = new ArrayList<>();
    private double totalReceita = 0.0;
    
    public Gerente() {
        this.isAdmin = true;
    }

    public boolean isCadastrado() {
        return cadastrado;
    }

    public void cadastrarGerente(Gerente gerente) {
        System.out.println("\n=====CADASTRO GERENTE=====");
        verificaNome(); 
        gerente.setNome(nome);
        verificarEmail(); 
        gerente.setEmail(email);
        verificarSenha(); 
        gerente.setSenha(senha);
        this.cadastrado = true; 
        System.out.println("Gerente " + getNome() + " cadastrado com sucesso!\n");
        menuGerente();
    }

    public void realizarLoginGerente() {
        if (!cadastrado) { 
            System.out.println("Você precisa cadastrar uma conta gerente antes de fazer login!\n");
            Main.contaGerente();
            return;
        } 
        
        System.out.println("\n=====LOGIN GERENTE=====");
        String emailInput;
        String senhaInput;
        
        //Verificação Email
        do {
            System.out.print("Email: ");
            emailInput = scanner.nextLine();
            if (emailInput == null || emailInput.trim().isEmpty()) {
                System.out.println("Email não pode ser vazio. Tente novamente.");
            }
        } while (emailInput == null || emailInput.trim().isEmpty());
        
        //Verificação Senha
        do {
            System.out.print("Senha: ");
            senhaInput = scanner.nextLine();
            if (senhaInput == null || senhaInput.trim().isEmpty()) {
                System.out.println("Senha não pode ser vazia. Tente novamente.");
            }
        } while (senhaInput == null || senhaInput.trim().isEmpty());
        
        if (emailInput.equals(this.email) && senhaInput.equals(this.senha)) {
            this.logado = true;  
            System.out.println("Login do gerente " + getNome() + " realizado com sucesso!\n");
            menuGerente();
        } else {
            System.out.println("Email ou senha incorretos.");
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

    public void menuGerente() {
        var option = -1;
        if (this.cadastrado) {
            do {
                System.out.println("\n=====MENU DO GERENTE=====");
                System.out.println("Olá gerente " + getNome() + ", seja bem-vindo!");
                System.out.println("Escolha uma das seguintes operações:");
                System.out.println("1 - Gerar relatório financeiro");
                System.out.println("2 - Consultar vendas");
                System.out.println("3 - Alterar dados");
                System.out.println("4 - Alterar senha");
                System.out.println("5 - Logout");
                System.out.print("Escolha uma opção: ");
                
                try {
                    option = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Entrada inválida!");
                    scanner.nextLine();
                    continue;
                }
                
                switch (option) {
                    case 1: gerarRelatorioFinanceiro(); break;
                    case 2: consultarVendas(); break;
                    case 3: alterarDadosGerente(); break;
                    case 4: alterarSenhaGerente(); break;
                    case 5: realizarLogoutGerente(); return;
                    default: System.out.println("Opção Inválida!"); break;
                }
            } while (option != 0);
        } else {
            System.out.println("Você ainda não cadastrou ou fez o login na conta gerente");
        }
    }

    public void gerarRelatorioFinanceiro() {
        System.out.println("\n===== RELATÓRIO FINANCEIRO =====");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Data/Hora: " + LocalDateTime.now().format(formatter));
        System.out.println("Gerente responsável: " + getNome());
        System.out.println("-----------------------------------");
        
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada no sistema.");
        } else {
            System.out.println("Total de vendas: " + vendas.size());
            System.out.println("Receita total: R$ " + String.format("%.2f", totalReceita));
            
            double ticketMedio = totalReceita / vendas.size();
            System.out.println("Ticket médio: R$ " + String.format("%.2f", ticketMedio));
            
            // Encontrar maior e menor venda
            double maiorVenda = vendas.get(0).getValorTotal();
            double menorVenda = vendas.get(0).getValorTotal();
            
            for (Venda v : vendas) {
                if (v.getValorTotal() > maiorVenda) maiorVenda = v.getValorTotal();
                if (v.getValorTotal() < menorVenda) menorVenda = v.getValorTotal();
            }
            
            System.out.println("Maior venda: R$ " + String.format("%.2f", maiorVenda));
            System.out.println("Menor venda: R$ " + String.format("%.2f", menorVenda));
        }
        System.out.println("===================================\n");
    }

    public void consultarVendas() {
        System.out.println("\n===== CONSULTA DE VENDAS =====");
        
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada no sistema.");
            return;
        }
        
        System.out.println("Total de vendas: " + vendas.size());
        System.out.println("-----------------------------------");
        
        for (int i = 0; i < vendas.size(); i++) {
            Venda v = vendas.get(i);
            System.out.println("Venda #" + (i + 1));
            System.out.println(v);
            System.out.println("-----------------------------------");
        }
    }

    public void alterarDadosGerente() {
        System.out.println("\n===== ALTERAR DADOS =====");
        String nome;
        
        //Verificação nome
        do {
            System.out.print("Novo Nome: ");
            nome = scanner.nextLine();
            if (nome == null || nome.trim().isEmpty()) {
                System.out.println("Nome não pode ser vazio. Tente novamente.");
            }
        } while (nome == null || nome.trim().isEmpty());
        this.setNome(nome);
        
        //Verificação email
        String email;
        do {
            System.out.print("Novo email: ");
            email = scanner.nextLine();
            if (email == null || email.trim().isEmpty()) {
                System.out.println("Email não pode ser vazio. Tente novamente.");
            } else if (!email.contains("@") || !email.contains(".")) {
                System.out.println("Email inválido. Deve conter @ e domínio.");
                email = null;
            }
        } while (email == null || email.trim().isEmpty());
        this.setEmail(email);
        
        System.out.println("Dados do gerente alterados com sucesso!");
    }

    public void alterarSenhaGerente() {
        System.out.println("\n===== ALTERAR SENHA =====");
        String senha;
        
        //Verificação senha
        do {
            System.out.print("Nova senha (mínimo 6 caracteres): ");
            senha = scanner.nextLine();
            if (senha == null || senha.trim().isEmpty()) {
                System.out.println("Senha não pode ser vazia. Tente novamente.");
            } else if (senha.length() < 6) {
                System.out.println("Senha deve ter no mínimo 6 caracteres.");
                senha = null;
            }
        } while (senha == null || senha.trim().isEmpty());
        
        this.setSenha(senha);
        System.out.println("Senha alterada com sucesso!");
    }
    
    // Método para adicionar venda (será usado pelo Vendedor)
    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
        totalReceita += venda.getValorTotal();
    }
    
    // Classe interna para representar uma venda
    public static class Venda {
        private String vendedor;
        private double valorUnitario;
        private int quantidade;
        private double valorTotal;
        private LocalDateTime dataHora;
        
        public Venda(String vendedor, double valorUnitario, int quantidade) {
            this.vendedor = vendedor;
            this.valorUnitario = valorUnitario;
            this.quantidade = quantidade;
            this.valorTotal = valorUnitario * quantidade;
            this.dataHora = LocalDateTime.now();
        }
        
        public double getValorTotal() {
            return valorTotal;
        }
        
        @Override
        public String toString() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            return "Vendedor: " + vendedor + "\n" +
                   "Data/Hora: " + dataHora.format(formatter) + "\n" +
                   "Valor unitário: R$ " + String.format("%.2f", valorUnitario) + "\n" +
                   "Quantidade: " + quantidade + "\n" +
                   "Valor total: R$ " + String.format("%.2f", valorTotal);
        }
    }
}
