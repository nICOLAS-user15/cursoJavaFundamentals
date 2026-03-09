import java.util.Scanner;
import java.util.Arrays;
import br.com.dio.calc.Operation;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a operação desejada (1 - SUM ou 2 - SUBTRACTION):");
        var operationOption = scanner.nextInt();
        while (operationOption > 2 || operationOption < 1) {
            System.out.println("Escolha uma opção válida (1 - SUM ou 2 - SUBTRACTION):");
            operationOption = scanner.nextInt();
        }
        var selectredOperation = Operation.values()[operationOption - 1];
        System.out.println("Informe os números que serão usados na operação separados por vírgula: (ex: 1,2,3)");
        var numbers = scanner.next();
        var numbersArray = Arrays.stream(numbers.split(",")).mapToLong(Long::parseLong).toArray();
        var result = selectredOperation.getOperationCallback().exec(numbersArray);
        var operationToShow = numbers.replaceAll(",",  " " + selectredOperation.getSignal() + " ");
        System.out.printf("O resultado da operação %s é: %s\n", operationToShow, result);
    }
}
