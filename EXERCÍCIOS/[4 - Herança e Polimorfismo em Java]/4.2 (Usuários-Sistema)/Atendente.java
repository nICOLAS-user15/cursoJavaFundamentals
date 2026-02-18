import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Atendente extends Empregado {
    private static final Scanner scanner = new Scanner(System.in);
    private boolean cadastrado = false;
    private boolean logado = false;
    private ArrayList<Pagamento> pagamentos = new ArrayList<>();
    private double totalCaixa = 0.0;
    
    public boolean isCadastrado() {
        return cadastrado;
    }

    public void cadastrarAtendente(Empregado empregado) {
        System.out.println("\n=====CADASTRO ATENDENTE=====");
        verificaNome(); 
        empregado.setNome(nome);
        verificarEmail(); 
        empregado.setEmail(email);
        verificarSenha(); 
        empregado.setSenha(senha);
        this.cadastrado = true;
        System.out.println("Atendente " + getNome() + " cadastrado com sucesso!");
        menuAtendente();
    }
    
    public void realizarLoginAtendente() {
        if (!cadastrado) {
            System.out.println("Você precisa cadastrar uma conta atendente antes de fazer login!\n");
            Main.contaAtendente();
            return;
        }
        
        System.out.println("\n=====LOGIN ATENDENTE=====");
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
            System.out.println("Login do atendente " + getNome() + " realizado com sucesso!\n");
            menuAtendente();
        } else {
            System.out.println("Email ou senha incorretos.");
        }
    }

    public void realizarLogoutAtendente() {
        if (this.logado) {
            this.logado = false;  
            System.out.println("Logout realizado com sucesso!");
        } else {
            System.out.println("Você não está logado.");
        }
    }

    public void menuAtendente() {
        var option = -1;
        do {
            System.out.println("\n=====MENU DO ATENDENTE=====");
            System.out.println("Olá atendente " + getNome() + ", seja bem-vindo!");
            System.out.println("Escolha uma das seguintes operações:");
            System.out.println("1 - Receber pagamentos");
            System.out.println("2 - Fechar caixa");
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
                case 1: receberPagamentos(); break;
                case 2: fecharCaixa(); break;
                case 3: alterarDadosAtendente(); break;
                case 4: alterarSenhaAtendente(); break;
                case 5: realizarLogoutAtendente(); return;
                default: System.out.println("Opção Inválida!"); break;
            }
        } while (option != 0);
    }

    public void receberPagamentos() {
        System.out.println("\n===== RECEBER PAGAMENTO =====");
        
        double valor = 0;
        boolean valorValido = false;
        
        while (!valorValido) {
            try {
                System.out.print("Informe o valor a receber: R$ ");
                valor = scanner.nextDouble();
                scanner.nextLine();
                
                if (valor <= 0) {
                    System.out.println("Erro: O valor deve ser maior que zero!");
                } else {
                    valorValido = true;
                }
            } catch (Exception e) {
                System.out.println("Erro: Digite um valor numérico válido!");
                scanner.nextLine();
            }
        }
        
        System.out.println("\nFormas de pagamento disponíveis:");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão de Débito");
        System.out.println("3 - Cartão de Crédito");
        System.out.println("4 - PIX");
        System.out.print("Escolha a forma de pagamento: ");
        
        int formaPagamento = 0;
        String descricaoFormaPagamento = "";
        
        try {
            formaPagamento = scanner.nextInt();
            scanner.nextLine();
            
            switch (formaPagamento) {
                case 1: descricaoFormaPagamento = "Dinheiro"; break;
                case 2: descricaoFormaPagamento = "Cartão de Débito"; break;
                case 3: descricaoFormaPagamento = "Cartão de Crédito"; break;
                case 4: descricaoFormaPagamento = "PIX"; break;
                default: 
                    System.out.println("Forma de pagamento inválida!");
                    return;
            }
        } catch (Exception e) {
            System.out.println("Erro: Escolha inválida!");
            scanner.nextLine();
            return;
        }
        
        // Se for dinheiro, calcular troco
        if (formaPagamento == 1) {
            double valorRecebido = 0;
            boolean recebidoValido = false;
            
            while (!recebidoValido) {
                try {
                    System.out.print("Valor recebido em dinheiro: R$ ");
                    valorRecebido = scanner.nextDouble();
                    scanner.nextLine();
                    
                    if (valorRecebido < valor) {
                        System.out.println("Erro: Valor insuficiente! Faltam R$ " + 
                                         String.format("%.2f", valor - valorRecebido));
                    } else {
                        recebidoValido = true;
                    }
                } catch (Exception e) {
                    System.out.println("Erro: Digite um valor numérico válido!");
                    scanner.nextLine();
                }
            }
            
            double troco = valorRecebido - valor;
            System.out.println("\n----- COMPROVANTE -----");
            System.out.println("Valor da compra: R$ " + String.format("%.2f", valor));
            System.out.println("Valor recebido: R$ " + String.format("%.2f", valorRecebido));
            System.out.println("Troco: R$ " + String.format("%.2f", troco));
        } else {
            System.out.println("\n----- COMPROVANTE -----");
            System.out.println("Valor: R$ " + String.format("%.2f", valor));
            System.out.println("Forma de pagamento: " + descricaoFormaPagamento);
        }
        
        // Registrar pagamento
        Pagamento pagamento = new Pagamento(valor, descricaoFormaPagamento, this.getNome());
        pagamentos.add(pagamento);
        totalCaixa += valor;
        
        System.out.println("Atendente: " + this.getNome());
        System.out.println("Data/Hora: " + LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("✓ Pagamento recebido com sucesso!");
        System.out.println("------------------------");
    }

    public void fecharCaixa() {
        System.out.println("\n===== FECHAMENTO DE CAIXA =====");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Data/Hora: " + LocalDateTime.now().format(formatter));
        System.out.println("Atendente: " + getNome());
        System.out.println("-----------------------------------");
        
        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento recebido hoje.");
            System.out.println("Total em caixa: R$ 0,00");
        } else {
            System.out.println("Total de transações: " + pagamentos.size());
            System.out.println("\nResumo por forma de pagamento:");
            
            double totalDinheiro = 0;
            double totalDebito = 0;
            double totalCredito = 0;
            double totalPix = 0;
            
            for (Pagamento p : pagamentos) {
                switch (p.getFormaPagamento()) {
                    case "Dinheiro": totalDinheiro += p.getValor(); break;
                    case "Cartão de Débito": totalDebito += p.getValor(); break;
                    case "Cartão de Crédito": totalCredito += p.getValor(); break;
                    case "PIX": totalPix += p.getValor(); break;
                }
            }
            
            if (totalDinheiro > 0) 
                System.out.println("Dinheiro: R$ " + String.format("%.2f", totalDinheiro));
            if (totalDebito > 0) 
                System.out.println("Cartão de Débito: R$ " + String.format("%.2f", totalDebito));
            if (totalCredito > 0) 
                System.out.println("Cartão de Crédito: R$ " + String.format("%.2f", totalCredito));
            if (totalPix > 0) 
                System.out.println("PIX: R$ " + String.format("%.2f", totalPix));
            
            System.out.println("-----------------------------------");
            System.out.println("TOTAL EM CAIXA: R$ " + String.format("%.2f", totalCaixa));
        }
        
        System.out.print("\nDeseja finalizar o caixa e zerar os valores? (S/N): ");
        String confirmacao = scanner.nextLine().toUpperCase();
        
        if (confirmacao.equals("S")) {
            pagamentos.clear();
            totalCaixa = 0.0;
            System.out.println("✓ Caixa finalizado e zerado com sucesso!");
        } else {
            System.out.println("Caixa não foi zerado.");
        }
        
        System.out.println("===================================\n");
    }

    public void alterarDadosAtendente() {
        System.out.println("\n===== ALTERAR DADOS =====");
        
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        if (nome != null && !nome.trim().isEmpty()) {
            this.setNome(nome);
        }
        
        System.out.print("Novo Email: ");
        String email = scanner.nextLine();
        if (email != null && !email.trim().isEmpty() && email.contains("@")) {
            this.setEmail(email);
        }
        
        System.out.println("Dados do atendente alterados com sucesso!");
    }

    public void alterarSenhaAtendente() {
        System.out.println("\n===== ALTERAR SENHA =====");
        String senha;
        
        do {
            System.out.print("Nova Senha (mínimo 6 caracteres): ");
            senha = scanner.nextLine();
            if (senha == null || senha.trim().isEmpty()) {
                System.out.println("Senha não pode ser vazia. Tente novamente.");
            } else if (senha.length() < 6) {
                System.out.println("Senha deve ter no mínimo 6 caracteres.");
                senha = null;
            }
        } while (senha == null || senha.trim().isEmpty());
        
        this.setSenha(senha);
        System.out.println("Senha do atendente alterada com sucesso!");
    }
    
    // Classe interna para representar um pagamento
    private static class Pagamento {
        private double valor;
        private String formaPagamento;
        private String atendente;
        private LocalDateTime dataHora;
        
        public Pagamento(double valor, String formaPagamento, String atendente) {
            this.valor = valor;
            this.formaPagamento = formaPagamento;
            this.atendente = atendente;
            this.dataHora = LocalDateTime.now();
        }
        
        public double getValor() {
            return valor;
        }
        
        public String getFormaPagamento() {
            return formaPagamento;
        }
    }
}
