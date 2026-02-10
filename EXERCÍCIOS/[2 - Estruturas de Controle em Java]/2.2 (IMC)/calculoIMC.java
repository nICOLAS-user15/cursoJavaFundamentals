import java.util.Scanner;

public class calculoIMC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("==========Cálculo IMC==========\nSeja bem vindo!");
        System.out.println("Informe sua altura: ");
        double altura = scanner.nextDouble();
        System.out.println("Informe seu peso: ");
        double peso = scanner.nextDouble(); 
        
        double calculoIMC = peso / (altura * altura);
        
        System.out.println(calculoIMC);
        if (calculoIMC <= 18.5){
            System.out.println("Abaixo do peso");
        }
        if (calculoIMC >= 18.6 && calculoIMC <= 24.9){
            System.out.println("Peso ideal");
        }
        if (calculoIMC >= 25 && calculoIMC <= 29.9){
            System.out.println("Levemente acima do peso");
        }
        if (calculoIMC >= 30 && calculoIMC <= 34.9){
            System.out.println("Obesidade grau I");
        }
        if (calculoIMC >= 35 && calculoIMC <= 39.9){
            System.out.println("Obesidade grau II");
        }
        if (calculoIMC >= 40){
            System.out.println("Obesidade graus III (mórbida)");
        }
        scanner.close();
    }
}
