import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Campo> campos = new ArrayList<>();

        System.out.println("Formato: NOME_CAMPO;VALOR;TIPO");
        System.out.println("Tipos  : texto | data | data e hora | inteiro | flutuante | booleano | array[tipo]");
        System.out.println("Digite 'fim' para encerrar.\n");

        int i = 1;
        while (true) {
            System.out.print("Campo " + i + ": ");
            String linha = scanner.nextLine().trim();
            if (linha.equalsIgnoreCase("fim") || linha.isEmpty()) break;
            Campo c = Conversor.parsear(linha, i);
            if (c != null) { campos.add(c); i++; }
        }

        if (campos.isEmpty()) {
            System.out.println("Nenhum campo informado.");
            return;
        }

        System.out.println("\n===== JSON =====");
        System.out.println(Conversor.json(campos));

        System.out.println("\n===== XML =====");
        System.out.println(Conversor.xml(campos));

        System.out.println("\n===== YAML =====");
        System.out.println(Conversor.yaml(campos));
    }
}