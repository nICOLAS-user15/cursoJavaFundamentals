import java.util.Scanner;

public class Empregado {
    private static final Scanner scanner = new Scanner(System.in);
    protected String nome;
    protected String senha;
    protected String email;
    protected boolean isAdmin;

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void verificaNome() {
        String nome;
        do {
            System.out.print("Nome: ");
            nome = scanner.nextLine();
            if (nome == null || nome.trim().isEmpty()) {
                System.out.println("Nome não pode ser vazio. Tente novamente.");
            }
        } while (nome == null || nome.trim().isEmpty());
        setNome(nome);
    }

    public void verificarEmail() {
        String email;
        do {
            System.out.print("Email: ");
            email = scanner.nextLine();
            if (email == null || email.trim().isEmpty()) {
                System.out.println("Email não pode ser vazio. Tente novamente.");
            } else if (!email.contains("@") || !email.contains(".")) {
                System.out.println("Email inválido. Deve conter @ e domínio.");
                email = null;
            }
        } while (email == null || email.trim().isEmpty());
        setEmail(email);
    }

    public void verificarSenha() {
        String senha;
        do {
            System.out.print("Senha (mínimo 6 caracteres): ");
            senha = scanner.nextLine();
            if (senha == null || senha.trim().isEmpty()) {
                System.out.println("Senha não pode ser vazia. Tente novamente.");
            } else if (senha.length() < 6) {
                System.out.println("Senha deve ter no mínimo 6 caracteres.");
                senha = null;
            }
        } while (senha == null || senha.trim().isEmpty());
        setSenha(senha);
    }
}
