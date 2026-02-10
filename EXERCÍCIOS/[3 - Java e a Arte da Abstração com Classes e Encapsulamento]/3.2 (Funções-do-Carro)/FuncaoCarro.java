import java.util.Scanner;

public class FuncaoCarro extends Carro {
    private final static Scanner scanner = new Scanner(System.in);

    public void solicitarMarcaCarro() {
        String marcaCarro = "";
        boolean marcaValida = false;
        
        while(!marcaValida) {
            System.out.println("Marca do carro: ");
            marcaCarro = scanner.nextLine().trim();
            if(marcaCarro.isEmpty()) {
                System.out.println("Erro: A marca do carro não pode ser vazia. Tente novamente.");
            } else if(marcaCarro.matches("\\d+")) {
                System.out.println("Erro: A marca do carro não pode ser apenas números. Tente novamente.");
            } else {
                marcaValida = true;
            }
        }
        setMarcaCarro(marcaCarro);
    }
    
    public void ligar() {
        if(!isLigado()) {
            setLigado(true);
            System.out.println("Carro " + getMarcaCarro() + " ligado.");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }

    public void desligar() {
        if (isLigado() && getVelocidade() == 0 && isPontoMorto()) {
            setLigado(false);
            setVelocidade(0);
            setPontoMorto(true);
            System.out.println("Carro " + getMarcaCarro() + " desligado.");
        } else if (!isPontoMorto()) {
            System.out.println("O carro não está em ponto morto. Coloque em ponto morto para desligar.");
        } else if (getVelocidade() > 0) {
            System.out.println("O carro está em movimento. Freie para desligar (Opção 4).");
        } else {
            System.out.println("O carro já está desligado.");
        }
    }

    private int getMarchaApropiada(int velocidade) {
        if (velocidade >= 0 && velocidade <= 20) {
            return 1;
        } else if(velocidade >= 21 && velocidade <= 40) {
            return 2;
        } else if(velocidade >= 41 && velocidade <= 60) {
            return 3;
        } else if(velocidade >= 61 && velocidade <= 80) {
            return 4;
        } else if(velocidade >= 81 && velocidade <= 100) {
            return 5;
        } else {
            return 6;
        }
    }

    public void acelerar() {
        if (!isLigado()) {
            System.out.println("Ligue o carro antes de acelerar (Opção 1).");
            return;
        }
        if (isPontoMorto()) {
            System.out.println("O carro está em ponto morto, troque de marcha (Opção 7).");
            return;
        }
        boolean continuarAcelerando = true;
        while (continuarAcelerando) {
            int velocidadeAtual = getVelocidade();
            int marchaAtual = getMarcha();
            int marchaApropiada = getMarchaApropiada(velocidadeAtual);
            if (marchaAtual != marchaApropiada && marchaAtual != 0) {
                System.out.println("\nAVISO: Você está na " + marchaAtual + "ª marcha, mas deveria estar na " + marchaApropiada + "ª marcha para a velocidade de " + velocidadeAtual + " km/h.");
                System.out.println("Troque de marcha (Opção 7) no menu antes de continuar acelerando.");
                continuarAcelerando = false;
                break;
            }
            int incremento;
            if (velocidadeAtual < 40) {
                incremento = 10;
            } else if(velocidadeAtual < 80) {
                incremento = 5;
            } else {
                incremento = 2;
            }
            if (velocidadeAtual + incremento <= 120) {
                setVelocidade(velocidadeAtual + incremento);
                System.out.println("Acelerando... Velocidade atual: " + getVelocidade() + " km/h (Marcha: " + marchaAtual + "ª)");
                int novaMarchaApropiada = getMarchaApropiada(getVelocidade());
                if (novaMarchaApropiada != marchaAtual) {
                    System.out.println("\nAVISO: Você atingiu a velocidade de " + getVelocidade() + " km/h!");
                    System.out.println("Troque para a " + novaMarchaApropiada + "ª marcha (Opção 7) para continuar acelerando com segurança.");
                    continuarAcelerando = false;
                    break;
                }
            } else {
                setVelocidade(120);
                System.out.println("O carro atingiu a velocidade máxima de 120 km/h.");
                continuarAcelerando = false;
                break;
            }
            System.out.println("\nDeseja continuar acelerando? (s/n): ");
            String opcao = scanner.nextLine().trim().toLowerCase();
            switch (opcao) {
                case "s": continuarAcelerando = true;
                    break;
                case "n": System.out.println("Saindo da aceleração.");
                    continuarAcelerando = false;
                    break;
                default: System.out.println("Opção inválida. Tente novamente.");
                    continuarAcelerando = false;
                    break;
            }
        }
    }

    public void frear() {
        if (!isLigado()) {
            System.out.println("Ligue o carro antes de frear.");
            return;
        }
        if (getVelocidade() == 0) {
            System.out.println("O carro já está parado.");
            return;
        }
        boolean continuarFreando = true;
        while (continuarFreando) {
            int velocidadeAtual = getVelocidade();
            int marchaAtual = getMarcha();
            int decremento;
            if (velocidadeAtual > 80) {
                decremento = 10;
            } else if (velocidadeAtual > 40) {
                decremento = 5;
            } else {
                decremento = 2;
            }
            if (velocidadeAtual - decremento >= 0) {
                setVelocidade(velocidadeAtual - decremento);
                System.out.println("Freando... Velocidade atual: " + getVelocidade() + " km/h (Marcha: " + marchaAtual + "ª)");
                int novaMarchaApropiada = getMarchaApropiada(getVelocidade());
                if (novaMarchaApropiada != marchaAtual && getVelocidade() > 0) {
                    System.out.println("\nAVISO: A velocidade caiu para " + getVelocidade() + " km/h!");
                    System.out.println("Você pode reduzir para a " + novaMarchaApropiada + "ª marcha (Opção 7) para melhor controle.");
                }
                if (getVelocidade() == 0) {
                    System.out.println("O carro parou completamente.");
                    continuarFreando = false;
                    break;
                }
            } else {
                setVelocidade(0);
                System.out.println("Freando... Velocidade atual: 0 km/h. O carro parou.");
                continuarFreando = false;
                break;
            }
            System.out.println("\nDeseja continuar freando? (s/n): ");
            String opcao = scanner.nextLine().trim().toLowerCase();
            switch (opcao) {
                case "s": continuarFreando = true;
                    break;
                case "n": System.out.println("Saindo da frenagem.");
                    continuarFreando = false;
                    break;
                default: System.out.println("Opção inválida. Tente novamente.");
                    continuarFreando = false;
                    break;
            }
        }
    }

    public void virar() {
        String direcao = "";
        if (!isLigado()) {
            System.out.println("O carro está desligado. Ligue o carro antes de virar (Opção 1).");
            return;
        }
        if ((this.getVelocidade() > 0 && this.getVelocidade() <= 40)) {
            if (!direcao.equalsIgnoreCase("E") && !direcao.equalsIgnoreCase("D")) {
                System.out.println("Direção inválida. Use 'E' para esquerda ou 'D' para direita.");
                return;
            }
            System.out.println("Para qual direção deseja virar? (esquerda/direita)");
            direcao = scanner.next();
            if (direcao.equalsIgnoreCase("E")) {
                direcao = "esquerda";
            } else {
                direcao = "direita";
            }
            System.out.println("Virando o carro para a " + direcao + ".");
        } 
        if (getVelocidade() > 40) {
            System.out.println("Reduza a velocidade para virar com segurança.");
        }
        if (getVelocidade() == 0) {
            System.out.println("O carro está parado. Acelere para poder virar.");
        }
    }

    public void verificarVelocidade() {
        if (isLigado()) {
            System.out.println("Velocidade atual: " + getVelocidade() + " km/h");
        } else {
            System.out.println("O carro está desligado, portanto a velocidade é 0 km/h.");
        }
    }

    public void trocarMarcha() {
        if (!isLigado()) {
            System.out.println("Ligue o carro antes de trocar a marcha (Opção 1).");
            return;
        }
        int marchaAnterior = getMarcha();
        int velocidade = getVelocidade();
        int novaMacha = getMarchaApropiada(velocidade);
        if (marchaAnterior == novaMacha) {
            System.out.println("O carro já está na " + novaMacha + "ª marcha.");
        } else {
            setMarcha(novaMacha);
            setPontoMorto(false);
            System.out.println("Marcha trocada de " + marchaAnterior + "ª para " + novaMacha + "ª. Velocidade: " + velocidade + " km/h");
        }
    }

}
