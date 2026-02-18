import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vendedor extends Empregado {
    private static final Scanner scanner = new Scanner(System.in);
    private boolean cadastrado = false;
    private boolean logado = false;
    private ArrayList<Gerente.Venda> minhasVendas = new ArrayList<>();
    
    public boolean isCadastrado() {
        return cadastrado;
    }

    public void cadastrarVendedor(Vendedor vendedor) {
        System.out.println("\n=====CADASTRO VENDEDOR=====");
        verificaNome(); 
        vendedor.setNome(nome);
        verificarEmail(); 
        vendedor.setEmail(email);
        verificarSenha(); 
        vendedor.setSenha(senha);
        this.cadastrado = true; 
        System.out.println("Vendedor " + getNome() + " cadastrado com sucesso!\n");
        menuVendedor();
    }

    public void realizarLoginVendedor() {
        if (!cadastrado) {
            System.out.println("Você precisa cadastrar uma conta vendedor antes de fazer login!\n");
            Main.contaVendedor();
            return;
        }
        
        System.out.println("\n=====LOGIN VENDEDOR=====");
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
            System.out.println("Login do vendedor " + getNome() + " realizado com sucesso!\n");
            menuVendedor();
        } else {
            System.out.println("Email ou senha incorretos.");
        }
    }

    public void realizarLogoutVendedor() {
        if (this.logado) {
            this.logado = false;  
            System.out.println("Logout realizado com sucesso!");
        } else {
            System.out.println("Você não está logado.");
        }
    }

    public void menuVendedor() {
        var option = -1;
        do {
            System.out.println("\n=====MENU DO VENDEDOR=====");
            System.out.println("Olá vendedor " + getNome() + ", seja bem-vindo!");
            System.out.println("Escolha uma das seguintes operações:");
            System.out.println("1 - Realizar venda");
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
                case 1: realizarVenda(); break;
                case 2: consultarVendas(); break;
                case 3: alterarDadosVendedor(); break;
                case 4: alterarSenhaVendedor(); break;
                case 5: realizarLogoutVendedor(); return;
                default: System.out.println("Opção Inválida!"); break;
            }
        } while (option != 0);
    }

    public void realizarVenda() {
        System.out.println("\n===== REALIZAR VENDA =====");
        
        double valor = 0;
        boolean valorValido = false;
        
        while (!valorValido) {
            try {
                System.out.print("Informe o valor unitário do produto: R$ ");
                valor = scanner.nextDouble();
                scanner.nextLine();
                
                if (valor <= 0) {
                    System.out.println("Erro: O valor do produto deve ser maior que zero!");
                } else {
                    valorValido = true;
                }
            } catch (Exception e) {
                System.out.println("Erro: Digite um valor numérico válido!");
                scanner.nextLine();
            }
        }
        
        int qtdProduto = 0;
        boolean qtdValida = false;
        
        while (!qtdValida) {
            try {
                System.out.print("Informe a quantidade de produtos: ");
                qtdProduto = scanner.nextInt();
                scanner.nextLine();
                
                if (qtdProduto <= 0) {
                    System.out.println("Erro: A quantidade de produtos deve ser maior que zero!");
                } else {
                    qtdValida = true;
                }
            } catch (Exception e) {
                System.out.println("Erro: Digite um número inteiro válido!");
                scanner.nextLine();
            }
        }
        
        double precoFinal = valor * qtdProduto;
        
        System.out.println("\n----- RESUMO DA VENDA -----");
        System.out.println("Valor unitário: R$ " + String.format("%.2f", valor));
        System.out.println("Quantidade: " + qtdProduto);
        System.out.println("Valor total: R$ " + String.format("%.2f", precoFinal));
        
        System.out.print("\nConfirmar venda? (S/N): ");
        String confirmacao = scanner.nextLine().toUpperCase();
        
        if (confirmacao.equals("S")) {
            Gerente.Venda venda = new Gerente.Venda(this.getNome(), valor, qtdProduto);
            minhasVendas.add(venda);
            System.out.println("✓ Venda registrada com sucesso!");
        } else {
            System.out.println("Venda cancelada.");
        }
    }

    public void consultarVendas() {
        System.out.println("\n===== MINHAS VENDAS =====");
        
        if (minhasVendas.isEmpty()) {
            System.out.println("Você ainda não realizou nenhuma venda.");
            return;
        }
        
        double totalVendido = 0;
        System.out.println("Total de vendas: " + minhasVendas.size());
        System.out.println("-----------------------------------");
        
        for (int i = 0; i < minhasVendas.size(); i++) {
            Gerente.Venda v = minhasVendas.get(i);
            System.out.println("Venda #" + (i + 1));
            System.out.println(v);
            System.out.println("-----------------------------------");
            totalVendido += v.getValorTotal();
        }
        
        System.out.println("TOTAL VENDIDO: R$ " + String.format("%.2f", totalVendido));
    }

    public void alterarDadosVendedor() {
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
        
        System.out.println("Dados do vendedor alterados com sucesso!");
    }

    public void alterarSenhaVendedor() {
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
        System.out.println("Senha do vendedor alterada com sucesso!");
    }
}

