import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IngressoCinema ingressoCinema = new IngressoCinema();
    private static final FuncaoCinema funcaoCinema = new FuncaoCinema();

    public static void main(String[] args) {
        System.out.println("========BEM VINDO AO CINEMA========");
        funcaoCinema.NomeFilme();
        funcaoCinema.DubladoLegendado();
        funcaoCinema.ValorIngresso();
        funcaoCinema.TipoIngresso();
    }
}
