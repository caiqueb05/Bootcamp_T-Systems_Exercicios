package Ex3;

public class Funcionarios<T> {
    private T detalheFuncionario;

    public Funcionarios(T detalheFuncionario) {
        this.detalheFuncionario = detalheFuncionario;
    }

    public void trabalhar() {
        System.out.println("Trabalhando em " + detalheFuncionario);
    }

    public void fazerPausa() {
        System.out.println("Fazendo uma pausa.");
    }

    public void reportar() {
        System.out.println("Reportando o progresso.");
    }
}