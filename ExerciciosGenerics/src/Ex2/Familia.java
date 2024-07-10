package Ex2;

public class Familia<T> {
    private T coisasEmFamilia;

    public Familia(T coisasEmFamilia) {
        this.coisasEmFamilia = coisasEmFamilia;
    }

    public void brincar() {
        System.out.println("Brincando em família.");
    }

    public void jantarJuntos() {
        System.out.println("Jantando em família.");
    }

    public void assistirFilme() {
        System.out.println("Assistindo a um filme em família.");
    }

    public void irPassear() {
        System.out.println("Indo passear em família.");
    }
}
