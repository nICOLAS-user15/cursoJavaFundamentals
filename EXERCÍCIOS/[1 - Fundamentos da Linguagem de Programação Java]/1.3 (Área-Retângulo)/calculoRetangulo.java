import java.util.Scanner;

public class calculoRetangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a base do retângulo: ");
        double base = scanner.nextDouble();
        System.out.println("Informe a altura do retângulo: ");
        double height =  scanner.nextDouble();

        double area = base * height;
        System.out.println("A área do retângulo é " + area);
        scanner.close();
    }
}
