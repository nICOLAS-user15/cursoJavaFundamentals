import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        GeometricForm geometricForm = null;
        var option = -1;
        do {
            System.out.println("Escolha a forma geométrica para calcular a área:");
            System.out.println("1 - Quadrado");
            System.out.println("2 - Retângulo");
            System.out.println("3 - Círculo");
            System.out.println("0 - SAIR");
            option = scanner.nextInt();
            switch (option) {
                case 1: geometricForm = createSquare(); break;
                case 2: geometricForm = createRectangle(); break;
                case 3: geometricForm = createCircle(); break;
                case 0: System.out.println("VOCÊ SAIU DO SISTEMA!"); break;
                default: System.out.println("OPÇÃO INVÁLIDA!"); continue;
            }
            if (option != 0 && geometricForm != null) System.out.println("RESULTADO = " + geometricForm.getArea());
        } while (option != 0);
        scanner.close();
    }
    

    private static GeometricForm createSquare(){
        System.out.println("Informe o tamanho dos lados: ");
        var side = scanner.nextDouble();
        return new Square(side);
    }

    private static GeometricForm createRectangle(){
        System.out.println("Informe a base: ");
        var base = scanner.nextDouble();
        System.out.println("Informe a altura: ");
        var height = scanner.nextDouble();
        return new Rectangle(height, base);
    }

    private static GeometricForm createCircle(){
        System.out.println("Informe o raio ");
        var radius = scanner.nextDouble();
        return new Circle(radius);
    }

}
