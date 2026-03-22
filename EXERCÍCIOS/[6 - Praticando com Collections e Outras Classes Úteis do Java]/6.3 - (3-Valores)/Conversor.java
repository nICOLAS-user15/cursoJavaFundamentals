import java.util.List;
import java.util.Set;

public class Conversor {

    private static final Set<String> BOOLEANOS = Set.of("true", "false", "verdadeiro", "falso");

    public static Campo parsear(String linha, int numero) {
        String[] p = linha.split(";", -1);

        if (p.length < 3 || p[0].isBlank() || p[1].isBlank() || p[2].isBlank()) {
            System.err.println("Campo " + numero + " inválido: use NOME;VALOR;TIPO");
            return null;
        }

        String nome  = p[0].trim();
        String valor = p[1].trim();
        Campo.Tipo tipo;

        try {
            tipo = Campo.Tipo.fromString(p[2].trim());
        } catch (IllegalArgumentException e) {
            System.err.println("Campo " + numero + ": " + e.getMessage());
            return null;
        }

        if (!valorValido(valor, tipo)) {
            System.err.println("Campo " + numero + ": valor incompatível com o tipo " + p[2].trim());
            return null;
        }

        return new Campo(nome, valor, tipo);
    }

    private static boolean valorValido(String valor, Campo.Tipo tipo) {
        if (tipo.isArray()) {
            for (String item : valor.split(","))
                if (!valorValido(item.trim(), tipo.tipoElemento())) return false;
            return true;
        }
        return switch (tipo) {
            case INTEIRO -> {
                try { Long.parseLong(valor); yield true; }
                catch (NumberFormatException e) { yield false; }
            }
            case FLUTUANTE -> {
                try { Double.parseDouble(valor.replace(",", ".")); yield true; }
                catch (NumberFormatException e) { yield false; }
            }
            case BOOLEANO -> BOOLEANOS.contains(valor.toLowerCase());
            default       -> true;
        };
    }

    public static String json(List<Campo> campos) {
        StringBuilder sb = new StringBuilder("{\n");
        for (int i = 0; i < campos.size(); i++) {
            Campo c = campos.get(i);
            sb.append("  \"").append(escJ(c.getNome())).append("\": ")
              .append(jsonValor(c.getValor(), c.getTipo()));
            if (i < campos.size() - 1) sb.append(",");
            sb.append("\n");
        }
        return sb.append("}").toString();
    }

    private static String jsonValor(String valor, Campo.Tipo tipo) {
        if (tipo.isArray()) {
            StringBuilder sb = new StringBuilder("[");
            String[] itens = valor.split(",");
            for (int i = 0; i < itens.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append(jsonValor(itens[i].trim(), tipo.tipoElemento()));
            }
            return sb.append("]").toString();
        }
        return switch (tipo) {
            case TEXTO, DATA, DATA_E_HORA -> "\"" + escJ(valor) + "\"";
            case INTEIRO                  -> valor;
            case FLUTUANTE                -> valor.replace(",", ".");
            case BOOLEANO                 -> bool(valor);
            default                       -> "\"" + escJ(valor) + "\"";
        };
    }

    public static String xml(List<Campo> campos) {
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<dados>\n");
        for (Campo c : campos) {
            String tag = c.getNome().replaceAll("[^\\w\\-.]", "_");
            if (Character.isDigit(tag.charAt(0))) tag = "_" + tag;
            sb.append("  <").append(tag).append(" tipo=\"").append(escX(c.getTipo().name().toLowerCase())).append("\"");
            if (c.getTipo().isArray()) {
                sb.append(">\n");
                for (String item : c.getValor().split(","))
                    sb.append("    <item>").append(escX(item.trim())).append("</item>\n");
                sb.append("  </").append(tag).append(">\n");
            } else {
                String val = switch (c.getTipo()) {
                    case FLUTUANTE -> c.getValor().replace(",", ".");
                    case BOOLEANO  -> bool(c.getValor());
                    default        -> c.getValor();
                };
                sb.append(">").append(escX(val)).append("</").append(tag).append(">\n");
            }
        }
        return sb.append("</dados>").toString();
    }

    public static String yaml(List<Campo> campos) {
        StringBuilder sb = new StringBuilder();
        for (Campo c : campos) {
            String chave = c.getNome().matches("[\\w\\-]+") ? c.getNome() : "\"" + c.getNome() + "\"";
            if (c.getTipo().isArray()) {
                sb.append(chave).append(":\n");
                for (String item : c.getValor().split(","))
                    sb.append("  - ").append(yamlValor(item.trim(), c.getTipo().tipoElemento())).append("\n");
            } else {
                sb.append(chave).append(": ").append(yamlValor(c.getValor(), c.getTipo())).append("\n");
            }
        }
        return sb.toString();
    }

    private static String yamlValor(String valor, Campo.Tipo tipo) {
        return switch (tipo) {
            case TEXTO                    -> "\"" + valor.replace("\"", "\\\"") + "\"";
            case DATA, DATA_E_HORA        -> valor;
            case INTEIRO                  -> valor;
            case FLUTUANTE                -> valor.replace(",", ".");
            case BOOLEANO                 -> bool(valor);
            default                       -> valor;
        };
    }

    private static String bool(String v) {
        return v.equalsIgnoreCase("true") || v.equalsIgnoreCase("verdadeiro") ? "true" : "false";
    }

    private static String escJ(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
    }

    private static String escX(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&apos;");
    }
}
