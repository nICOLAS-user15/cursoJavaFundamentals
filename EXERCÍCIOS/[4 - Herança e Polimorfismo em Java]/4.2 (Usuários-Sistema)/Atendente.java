import java.util.Scanner;

public class Atendente extends Empregado{
    private static final Scanner scanner = new Scanner(System.in);

    public void cadastrarAtendente(Empregado empregado) {
        System.out.println("=====CADASTRO DE ATENDENTE=====");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        empregado.setNome(nome);
        System.out.println("Email: ");
        String email = scanner.nextLine();
        empregado.setEmail(email);
        System.out.println("Senha: ");
        String senha = scanner.nextLine();
        empregado.setSenha(senha);
        System.out.println("Atendente cadastrado com sucesso!");
        menuAtendente();
        return;
    }
    
    public void realizarLoginAtendente(){

    }

    public void realizarLogoutAtendente(){

    }

    public void menuAtendente(){
        var option = -1;
        do {
            System.out.println("=====MENU DO GERENTE=====");
            System.out.println("Olá getente " + getNome() + ", seja bem vindo!");
            System.out.println("Escolha uma das seguinte operações:");
            System.out.println("1 - Receber pagamentos");
            System.out.println("2 -  Fechar caixa");
            System.out.println("3 - Alterar dados");
            System.out.println("4 -  Alterar senha");
            System.out.println("0 - SAIR");
            option = scanner.nextInt();
        } while (option != 0);
        switch (option) {
            case 1: receberPagamentos();
                break;
            case 2: fecharCaixa();
                break;
            case 3: alterarDadosAtendente();
                break;
            case 4: alterarSenhaAtendente();
                break;
            case 0: System.out.println("Você saiu do sistema!");
            default: System.out.println("Opção Inválida!");
                break;
        }
    }

    public void receberPagamentos(){

    }

    public void fecharCaixa(){

    }

    public void alterarDadosAtendente(){

    }

    public void alterarSenhaAtendente(){

    }
}
