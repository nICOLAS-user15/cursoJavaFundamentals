import java.util.Scanner;

public class diferencaIdade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome da primeira pessoa: ");
        var nome1 = scanner.nextLine();
        System.out.println("Informe sua idade: ");
        int idade1 = scanner.nextInt();

        System.out.println("Informe o nome da segunda pessoa: ");
        var nome2 = scanner.next();
        System.out.println("Informe sua idade: ");
        int idade2 = scanner.nextInt();

        int diferencaIdade = Math.abs(idade1 - idade2);
        System.out.printf("A diferença de idade entre %s e %s é de %s anos", nome1, nome2, diferencaIdade);
        scanner.close();
    }
}
