public class Campo {

    public enum Tipo {
        TEXTO, DATA, DATA_E_HORA, INTEIRO, FLUTUANTE, BOOLEANO,
        ARRAY_TEXTO, ARRAY_DATA, ARRAY_DATA_E_HORA,
        ARRAY_INTEIRO, ARRAY_FLUTUANTE, ARRAY_BOOLEANO;

        public boolean isArray() {
            return name().startsWith("ARRAY_");
        }

        public Tipo tipoElemento() {
            return switch (this) {
                case ARRAY_TEXTO       -> TEXTO;
                case ARRAY_DATA        -> DATA;
                case ARRAY_DATA_E_HORA -> DATA_E_HORA;
                case ARRAY_INTEIRO     -> INTEIRO;
                case ARRAY_FLUTUANTE   -> FLUTUANTE;
                case ARRAY_BOOLEANO    -> BOOLEANO;
                default                -> this;
            };
        }

        public static Tipo fromString(String s) {
            return switch (s.trim().toLowerCase()) {
                case "texto"                              -> TEXTO;
                case "data"                               -> DATA;
                case "data e hora"                        -> DATA_E_HORA;
                case "inteiro"                            -> INTEIRO;
                case "flutuante"                          -> FLUTUANTE;
                case "booleano"                           -> BOOLEANO;
                case "array[texto]"                       -> ARRAY_TEXTO;
                case "array[data]"                        -> ARRAY_DATA;
                case "array[data e hora]"                 -> ARRAY_DATA_E_HORA;
                case "array[inteiro]"                     -> ARRAY_INTEIRO;
                case "array[flutuante]"                   -> ARRAY_FLUTUANTE;
                case "array[booleano]"                    -> ARRAY_BOOLEANO;
                default -> throw new IllegalArgumentException("Tipo desconhecido: " + s);
            };
        }
    }

    private final String nome;
    private final String valor;
    private final Tipo tipo;

    public Campo(String nome, String valor, Tipo tipo) {
        this.nome  = nome;
        this.valor = valor;
        this.tipo  = tipo;
    }

    public String getNome()  { return nome;  }
    public String getValor() { return valor; }
    public Tipo   getTipo()  { return tipo;  }
}