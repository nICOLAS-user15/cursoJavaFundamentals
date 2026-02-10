import java.util.Scanner;

public class FuncaoBanco extends ContaBancaria {
    private Scanner scanner = new Scanner(System.in);

    public void CriarConta() {
        System.out.println("Informe o valor do depósito inicial: ");
        double depositoInicial = scanner.nextDouble();
        if (depositoInicial <= 0) {
            System.out.println("Valor inválido. Conta não criada. Saindo...");
            System.exit(0);
        }
        setSaldo(depositoInicial);
        if (depositoInicial <= 500) {
            setLimiteChequeEspecial(50);
        } else {
            setLimiteChequeEspecial(depositoInicial * 0.5);
        }
        System.out.println("Conta criada com sucesso! Saldo: R$ " + String.format("%.2f", getSaldo()) + ", Cheque especial: R$ " + String.format("%.2f", getLimiteChequeEspecial()));
    }

    public void ConsultarSaldo() {
        System.out.println("Seu saldo é: R$ " + String.format("%.2f", getSaldo()));
    }

    public void ConsultarChequeEspecial() {
        System.out.println("Seu limite de cheque especial é: R$ " + String.format("%.2f", getLimiteChequeEspecial()));
    }

    public void Depositar() {
        System.out.println("Informe o valor para o depósito: ");
        double valorDeposito = scanner.nextDouble();
        if (valorDeposito <= 0) {
            System.out.println("Valor inválido para depósito.");
            return;
        }
        double saldoAnterior = getSaldo();
        setSaldo(getSaldo() + valorDeposito);
        if (saldoAnterior < 0 && getSaldo() >= 0) {
            double taxa = getValorUsadoChequeEspecial() * 0.20;
            setSaldo(getSaldo() - taxa);
            System.out.println("Taxa de cheque especial cobrada: R$ " + String.format("%.2f", taxa));
            setValorUsadoChequeEspecial(0);
        }
        System.out.println("Depósito realizado com sucesso!");
    }

    public void Sacar() {
        System.out.println("Informe o valor para o saque: ");
        double valorSaque = scanner.nextDouble();
        if (valorSaque <= 0) {
            System.out.println("Valor inválido para saque.");
            return;
        }
        if (valorSaque > getSaldo() + getLimiteChequeEspecial()) {
            System.out.println("Saldo insuficiente para saque.");
            return;
        }
        setSaldo(getSaldo() - valorSaque);
        if (getSaldo() < 0) {
            setValorUsadoChequeEspecial(-getSaldo());
        }
        System.out.println("Saque realizado com sucesso!");
    }

    public void PagarBoleto() {
        System.out.println("Informe o valor do boleto a ser pago: ");
        double valorBoleto = scanner.nextDouble();
        if (valorBoleto <= 0) {
            System.out.println("Valor inválido para pagamento de boleto.");
            return;
        }
        if (valorBoleto > getSaldo() + getLimiteChequeEspecial()) {
            System.out.println("Saldo insuficiente para pagar o boleto.");
            return;
        }
        setSaldo(getSaldo() - valorBoleto);
        if (getSaldo() < 0) {
            setValorUsadoChequeEspecial(-getSaldo());
        }
        System.out.println("Boleto pago com sucesso!");
    }

    public void VerificarChequeEspecial() {
        if (getSaldo() < 0) {
            System.out.println("Sua conta está usando cheque especial.");
        } else {
            System.out.println("Sua conta não está usando cheque especial.");
        }
    }
}