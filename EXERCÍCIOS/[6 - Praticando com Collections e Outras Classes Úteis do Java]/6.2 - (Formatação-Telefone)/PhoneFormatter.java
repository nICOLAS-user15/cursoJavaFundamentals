import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("-----Formatador de Números de Telefone-----");
        System.out.println("Formatos aceitos:");
        System.out.println("Fixo  s/ DDD : xxxx-xxxx    (8 dígitos) ");
        System.out.println("Fixo  c/ DDD : (xx)xxxx-xxxx (10 díg.)");
        System.out.println("Cel.  s/ DDD : xxxxx-xxxx   (9 dígitos)");
        System.out.println("Cel.  c/ DDD : (xx)xxxxx-xxxx (11 díg.)");
        System.out.println("Digite 'sair' para encerrar.");

        while (true) {
            System.out.print("\nINFORME UM NÚMERO DE TELEFONE: ");
            String input = scanner.nextLine();
    
            if (input.equalsIgnoreCase("sair")) {
                System.out.println("--VOCÊ SAIU DO PROGRAMA--");
                break;
            }
            System.out.println(process(input));
        }
    
        scanner.close();
    }
    
    private static final Map<Integer, PhoneType> DIGIT_MAP = new LinkedHashMap<>();

    static {
        for (PhoneType t : PhoneType.values()) {
            DIGIT_MAP.put(t.digits, t);
        }
    }

    private static String extractDigits(String input) {
        return input.replaceAll("[^0-9]", "");
    }

    private static PhoneType detectAlreadyFormatted(String input) {
        // Padrões aceitos (regex) para cada tipo de telefone
        Map<String, PhoneType> patterns = new LinkedHashMap<>();
        patterns.put("^\\(\\d{2}\\)\\d{5}-\\d{4}$", PhoneType.CELULAR_COM_DDD);
        patterns.put("^\\(\\d{2}\\)\\d{4}-\\d{4}$", PhoneType.FIXO_COM_DDD);
        patterns.put("^\\d{5}-\\d{4}$", PhoneType.CELULAR_SEM_DDD);
        patterns.put("^\\d{4}-\\d{4}$", PhoneType.FIXO_SEM_DDD);

        for (Map.Entry<String, PhoneType> entry : patterns.entrySet()) {
            if (input.matches(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    // Processa a entrada do usuário e retorna o resultado formatado ou mensagens de erro
    static String process(String input) {
        if (input == null || input.isBlank()) {
            return "Entrada vazia – nenhum número para processar.";
        }

        String trimmed = input.strip();

        //1. Verificar se já está formatado corretamente
        PhoneType alreadyOk = detectAlreadyFormatted(trimmed);
        if (alreadyOk != null) {
            return String.format("Número já formatado corretamente: %s%n   Tipo: %s",
                    trimmed, alreadyOk.label);
        }

        //2. Extrair apenas dígitos
        String digits = extractDigits(trimmed);

        if (digits.isEmpty()) {
            return "Entrada inválida – nenhum dígito encontrado.";
        }

        //3. Consultar o Map pelo total de dígitos 
        PhoneType type = DIGIT_MAP.get(digits.length());

        if (type == null) {
            return String.format(
                "Número inválido – %d dígito(s) encontrado(s). " +
                "Esperado: 8 (fixo s/ DDD), 9 (cel. s/ DDD), " +
                "10 (fixo c/ DDD) ou 11 (cel. c/ DDD).",
                digits.length());
        }

        //4. Verificar se a entrada original era "só números"
        boolean onlyDigits = trimmed.matches("\\d+");

        //5. Verificar se havia máscara mas estava errada
        boolean hadNonDigits = !onlyDigits;

        String formatted = type.format(digits);

        if (onlyDigits) {
            return String.format("Número formatado: %s%n   Tipo: %s",
                    formatted, type.label);
        } else {
            // Havia caracteres extras / máscara incorreta
            return String.format(
                "Entrada com máscara incorreta ou caracteres extras.%n" +
                "Original: %s%n" +
                "Corrigido: %s%n" +
                "Tipo: %s",
                trimmed, formatted, type.label);
        }
    }
}