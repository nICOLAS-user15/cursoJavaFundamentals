import java.util.Scanner;

public class NomeIdade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe seu nome: ");
        var nome = scanner.nextLine();

        System.out.println("Informe o ano do seu nascimento: ");
        int ano = scanner.nextInt();

        int anoAtual = 2026;
        int result = anoAtual - ano;
        
        System.out.println("Olá "+ nome + ", você tem " + result + " anos de idade.");
        scanner.close();
    }
}