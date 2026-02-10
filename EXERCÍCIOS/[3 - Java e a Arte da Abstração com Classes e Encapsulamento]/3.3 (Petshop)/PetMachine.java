import java.util.Scanner;

public class PetMachine {
    private final static Scanner scanner = new Scanner(System.in);
    private Pet pet;
    private boolean clean = true;
    private int waterLevel = 30;
    private int shampooLevel = 10;

    public void removePet() {
        if (!hasPet()) {
            System.out.println("Não há pet na máquina para ser removido. Coloque um pet na máquina (Opção 1).");
            return;
        }
        if (hasPet() && !pet.isClean()) {
            System.out.println("O pet " + pet.getName() + " ainda não está limpo. Dê o banho antes de retirá-lo (Opção 3).");
            System.out.println("Deseja retirar o pet mesmo assim? (S/N): ");
            var response = scanner.next().trim().toUpperCase();
            if (response.equals("S")) {    
                System.out.println("O pet " + pet.getName() + " foi retirado da máquina.");
                this.pet = null;
                return;
            } else {
                System.out.println("Ok! O pet " + pet.getName() + " continua na máquina. Dê um banho nele (Opção 3).");
                return;
            }
        }else {
            System.out.println("O pet " + pet.getName() + " foi retirado da máquina.");
            this.pet = null;
        }
    }

    public boolean isClean() {
        return clean;
    }

    public void takeAShowerInPet() {
        if (!hasPet()) {
            System.out.println("A máquina está vazia. Coloque um pet para dar banho (Opção 1).");
            return;
        }
        if (pet.isClean()) {
            System.out.println("O pet " + pet.getName() + " já tomou banho e está limpo!");
            return;
        }
        if (waterLevel < 10) {
            System.out.println("Água insuficiente para dar banho. Abasteça a máquina (Opção 8).");
            return;
        }
        if (shampooLevel < 2) {
            System.out.println("Shampoo insuficiente para dar banho. Abasteça a máquina (Opção 9).");
            return;
        }
        if (!this.clean) {
            System.out.println("Ops! A máquina está suja. Limpe a máquina antes de dar banho no pet (Opção 5).");
            return;
        } 
        this.clean = false;
        waterLevel -= 10;
        shampooLevel -= 2;
        pet.setClean(true);
        System.out.println("Tomando banho...\nO pet " + pet.getName() + " está limpo agora!");
    }

    public void addWater() {
        if (waterLevel >= 30) {
            System.out.println("Nível de água já está cheio.");
            return;
        } 
        waterLevel = 30;
        System.out.println("Nível de água reabastecido.");
    }

    public void addShampoo() {
        if (shampooLevel >= 10) {
            System.out.println("Nível de shampoo já está cheio.");
            return;
        } 
        shampooLevel = 10;
        System.out.println("Nível de shampoo reabastecido.");
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getShampooLevel() {
        return shampooLevel;
    }

    public void setShampooLevel(int shampooLevel) {
        this.shampooLevel = shampooLevel;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        if (!this.clean) {
            System.out.println("Ops! A máquina está suja. Limpe-a antes de colocar um novo pet (Opção 5).");
            return;
        }
        this.pet = pet;
        System.out.println("O pet " + pet.getName() + " foi colocado na máquina.");
    }

    public void wash() {
        if (isClean()) {
            System.out.println("A máquina já está limpa!");
            return;
        }
        if (!this.clean) {
            System.out.println("Ops! A máquina está suja. Limpe a máquina antes de usar (Opção 5).");
        }
        if (hasPet()) {
            System.out.println("A máquina está com o pet " + pet.getName() + " no momento. Aguarde o banho ser dado ou retire o pet para limpar a máquina.");
        } 
        if (waterLevel < 10) {
            System.out.println("Água insuficiente para limpar a máquina. Abasteça a máquina (Opção 8).");
            return;
        }
        if (shampooLevel < 2) {
            System.out.println("Shampoo insuficiente para limpar a máquina. Abasteça a máquina (Opção 9).");
            return;
        }
        this.waterLevel -= 10;
        this.shampooLevel -= 2;
        this.clean = true;
        System.out.println("A máquina foi limpa.");
    }
}