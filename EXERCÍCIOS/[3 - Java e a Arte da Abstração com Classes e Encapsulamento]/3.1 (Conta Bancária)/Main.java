import java.util.Scanner;

public final class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static FuncaoBanco conta = new FuncaoBanco();

    public static void main(String[] args) {
        conta.CriarConta();
        var option = -1;
        do {
            System.out.println("=====BEM VINDO AO SEU BANCO=====");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar um boleto");
            System.out.println("6 - Verificar se a conta está usando cheque especial");
            System.out.println("0 - SAIR");
            option = scanner.nextInt();

            switch (option) {
                case 1: conta.ConsultarSaldo();
                    break;
                case 2: conta.ConsultarChequeEspecial();
                    break;
                case 3: conta.Depositar();
                    break;
                case 4: conta.Sacar();
                    break;
                case 5: conta.PagarBoleto();
                    break;
                case 6: conta.VerificarChequeEspecial();
                    break;
                case 0: System.out.println("Voce saiu! Obrigado por usar nosso banco!");
                    break;
                default: System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        } while (option != 0);
        scanner.close();
    }
}