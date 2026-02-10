import java.util.Scanner;

public class Vendedor extends Empregado{
    private static final Scanner scanner = new Scanner(System.in);

    public void cadastrarVendedor(Empregado empregado) {
        System.out.println("=====CADASTRO DE VENDEDOR=====");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        empregado.setNome(nome);
        System.out.println("Email: ");
        String email = scanner.nextLine();
        empregado.setEmail(email);
        System.out.println("Senha: ");
        String senha = scanner.nextLine();
        empregado.setSenha(senha);
        System.out.println("Quantidade de vendas: ");
        int qtdVendas = scanner.nextInt();
        if (qtdVendas == 0){
            System.out.println("A quantidade de vendas não pode ser 0");
            return;
        } else
        System.out.println("Vendedor " + getNome() + "cadastrado com sucesso!\n");
        menuVendedor();
        return;
    }

    public void realizarLoginVendedor(){

    }

    public void realizarLogoutVendedor(){

    }

    public void menuVendedor(){
        var option = -1;
        do{
            System.out.println("=====MENU DO VENDEDOR=====");
            System.out.println("Olá vendedor " + getNome() + ", seja bem vindo!");
            System.out.println("Escolha uma das seguinte operações:");
            System.out.println("1 - Realizar venda");
            System.out.println("2 - Consultar vendas");
            System.out.println("3 - Alterar dados");
            System.out.println("4 - Alterar senha");
            System.out.println("0 - SAIR");
            option = scanner.nextInt();
        } while(option != 0);
        switch (option) {
            case 1: realizarVenda();
                break;
            case 2: consultarVendas();
                break;
            case 3: alterarDadosVendedor();
                break;
            case 4: alterarSenhaVendedor();
                break;
            case 0: System.out.println("Você saiu do sistema!");
                break;
            default: System.out.println("Opção Inválida!");
                break;
        }
    }
        
    

    public void realizarVenda(){
        
    }

    public void consultarVendas(){
        
    }


    public void alterarDadosVendedor(){

    }

    public void alterarSenhaVendedor(){

    }
}
