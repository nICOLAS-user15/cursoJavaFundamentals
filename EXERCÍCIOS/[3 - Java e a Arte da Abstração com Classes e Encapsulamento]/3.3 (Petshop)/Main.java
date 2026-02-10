import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    private final static PetMachine petMachine = new PetMachine();
    public static void main(String[] args) {
        var option = -1;
        do {
            System.out.println("=====Bem vindo ao PETSHOP=====\nEscolha uma opção: ");
            System.out.println("1 - Colocar pet na máquina");
            System.out.println("2 - Retirar pet da máquina");
            System.out.println("3 - Dar banho no pet");
            System.out.println("4 - Verificar se tem pet na máquina");
            System.out.println("5 - Limpar máquina");
            System.out.println("6 - Verificar nível de água da máquina");
            System.out.println("7 - Verificar nível de shampoo da máquina");
            System.out.println("8 - Abastecer água da máquina");
            System.out.println("9 - Abastecer shampoo da máquina");
            System.out.println("0 - Sair");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    setPetInMachine();
                    break;
                case 2:
                    petMachine.removePet();
                    break;
                case 3:
                    giveBathToPet();
                    break;
                case 4:
                    checkIfHasPetInMachine();
                    break;
                case 5:
                    petMachine.wash();
                    break;
                case 6:
                    verifyWater();
                    break;
                case 7:
                    verifyShampoo();
                    break;
                case 8:
                    petMachine.addWater();
                    break;
                case 9:
                    petMachine.addShampoo();
                    break;
                case 0:
                    System.out.println("Você saiu do PetShop. VOLTE SEMPRE!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (option != 0);
        scanner.close();
    }

    public static void setPetInMachine() {
        scanner.nextLine(); 
        String name;
        do {
            if (petMachine.hasPet()) {
                System.out.println("Já há um pet na máquina. Retire-o antes de colocar outro (Opção 2).");
                return;
            }
            System.out.println("Informe o nome do pet: ");
            name = scanner.nextLine().trim();
        } while (name.isEmpty());
        var pet = new Pet(name);
        petMachine.setPet(pet);
    }

    private static void giveBathToPet() {
        petMachine.takeAShowerInPet();
    }

    private static void verifyShampoo() {
        var amount = petMachine.getShampooLevel();
        System.out.println("A máquina está no momento com " + amount + " litro(s) de shampoo.");
    }

    private static void verifyWater() {
        var amount = petMachine.getWaterLevel();
        System.out.println("A máquina está no momento com " + amount + " litro(s) de água.");
    }

    private static void checkIfHasPetInMachine() {
        var hasPet = petMachine.hasPet();
        System.out.println(hasPet ? "O pet " + petMachine.getPet().getName() + " está na máquina." : "Não há pet na máquina.");
    }
}