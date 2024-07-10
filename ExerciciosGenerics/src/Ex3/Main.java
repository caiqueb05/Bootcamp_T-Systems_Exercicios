package Ex3;

public class Main {
    public static void main(String[] args) {
        Funcionarios<String> funcionario = new Funcionarios<String>("Desenvolvimento de software.");
        funcionario.trabalhar();
        funcionario.fazerPausa();
        funcionario.reportar();
    }
}
