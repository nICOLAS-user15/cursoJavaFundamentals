import java.util.Scanner;

public class CalculoArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========ÁREA DO QUADRADO==========");
        System.out.println("Informe o tamanho de um lado do quadrado: ");
        double lado = scanner.nextDouble();

        double areaQuadrado = lado * lado;
        var result = areaQuadrado;

        System.out.println("A área do quadrado é " + result);

        scanner.close();
    }
}
