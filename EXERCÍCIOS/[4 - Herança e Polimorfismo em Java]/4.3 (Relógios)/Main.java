import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BRClock brClock = new BRClock();
        USAclock usaClock = new USAclock();

        boolean running = true;

        System.out.println("Relógio");
        System.out.println("===============");

        while (running) {
            System.out.println("1. Informar Hora Brasileira");
            System.out.println("2. Informar Hora Americana ");
            System.out.println("3. Converter");
            System.out.println("4. SAIR");
            System.out.print("Escolha: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Hora: ");
                    brClock.setHoras(scanner.nextInt());
                    System.out.print("Minutos: ");
                    brClock.setMinutos(scanner.nextInt());
                    System.out.print("Segundos: ");
                    brClock.setSegundos(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("BR: " + brClock.getTime());
                }
                case 2 -> {
                    System.out.print("Hour: ");
                    int h = scanner.nextInt();
                    System.out.print("AM/PM: ");
                    String p = scanner.next().toUpperCase();
                    scanner.nextLine();
                    if (p.equals("PM") && h != 12) h += 12;
                    else if (p.equals("AM") && h == 12) h = 0;
                    usaClock.setHoras(h);
                    if (p.equals("PM")) usaClock.setAfterMidDay();
                    else usaClock.setBeforeMidDay();
                    System.out.print("Minutes: ");
                    usaClock.setMinutos(scanner.nextInt());
                    System.out.print("Seconds: ");
                    usaClock.setSegundos(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("USA: " + usaClock.getTime());
                }
                case 3 -> {
                    System.out.print("Converter relógio BR para USA (1) ou USA para BR (2): ");
                    int dir = scanner.nextInt();
                    scanner.nextLine();
                    if (dir == 1) {
                        usaClock.convert(brClock);
                        System.out.println("USA: " + usaClock.getTime());
                    } else if (dir == 2) {
                        brClock.convert(usaClock);
                        System.out.println("BR: " + brClock.getTime());
                    } else {
                        System.out.println("Inválido.");
                    }
                }
                case 4 -> {
                    System.out.println("Você saiu do relógio. Até logo!");
                    running = false;
                }
                default -> System.out.println("Inválido.");
            }
            System.out.println();
        }

        scanner.close();
    }
}
