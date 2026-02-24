import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ValorTributo valorTributo = null;
        var option = -1;
        do{
            System.out.println("-----TRIBUTOS PARA PRODUTOS-----");
            System.out.println("1 - Alimentação");
            System.out.println("2 - Saúde e Bem-Estar");
            System.out.println("3 - Vestuário");
            System.out.println("4 - Cultura");
            System.out.println("0 - SAIR");
            System.out.println("Escolha uma categoria de produto: ");
            option = scanner.nextInt();
            switch (option) {
                case 1: valorTributo = calcularAlimentacao(); break;
                case 2: valorTributo = calcularSaudeBemEstar(); break;
                case 3: valorTributo = calcularVestuario(); break;
                case 4: valorTributo = calcularCultura(); break;
                case 0: System.out.println("VOCÊ SAIU DO PROGRAMA!");break;
                default:System.out.println("OPÇÃO INVÁLIDA!"); break;
            }
        } while (option != 0);
        scanner.close();
    }

    public static ValorTributo calcularAlimentacao() {
        System.out.println("Digite o valor do produto: ");
        var valor = scanner.nextDouble();
        var valorTributo = new Alimentacao(valor);
        System.out.println("O valor do tributo para o produto é: " + valorTributo.calcularValorTributo());
        return valorTributo;
    }

    public static ValorTributo calcularSaudeBemEstar() {
        System.out.println("Digite o valor do produto: ");
        var valor = scanner.nextDouble();
        var valorTributo = new SaudeBemEstar(valor);
        System.out.println("O valor do tributo para o produto é: " + valorTributo.calcularValorTributo());
        return valorTributo;
    }

    public static ValorTributo calcularVestuario() {
        System.out.println("Digite o valor do produto: ");
        var valor = scanner.nextDouble();
        var valorTributo = new Vestuario(valor);
        System.out.println("O valor do tributo para o produto é: " + valorTributo.calcularValorTributo());
        return valorTributo;
    }

    public static ValorTributo calcularCultura() {
        System.out.println("Digite o valor do produto: ");
        var valor = scanner.nextDouble();
        var valorTributo = new Cultura(valor);
        System.out.println("O valor do tributo para o produto é: " + valorTributo.calcularValorTributo());
        return valorTributo;
    }
}
