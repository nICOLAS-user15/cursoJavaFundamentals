import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static FuncaoCarro funcaoCarro = new FuncaoCarro();
    public static void main(String[] args) {
        var option = -1;

        System.out.println("=====BEM VINDO AO SEU CARRO=====");
        funcaoCarro.solicitarMarcaCarro();

        System.out.println("Escolha uma opção: ");
        do {
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Frear");
            System.out.println("5 - Virar para a esquerda/direita");
            System.out.println("6 - Verificar velocidade");
            System.out.println("7 - Trocar a marcha");
            System.out.println("0 - SAIR");
            option = scanner.nextInt();

            switch(option) {
                case 1: funcaoCarro.ligar();
                    break;
                case 2: funcaoCarro.desligar(); 
                    break;
                case 3: funcaoCarro.acelerar();
                    break;
                case 4: funcaoCarro.frear();
                    break;
                case 5: funcaoCarro.virar();
                    break;
                case 6: funcaoCarro.verificarVelocidade();
                    break;
                case 7: funcaoCarro.trocarMarcha();
                    break;
                case 0: System.out.println("Saindo do carro " + funcaoCarro.getMarcaCarro() + ". Até mais!");
                    break;
                default:
                    if(option != 0) {
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;
            } 
        } while(option != 0);
        scanner.close();
    }
}
