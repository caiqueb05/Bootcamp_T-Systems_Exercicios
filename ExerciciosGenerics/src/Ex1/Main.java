package Ex1;

public class Main {
    public static void main(String[] args) {
        Fila<String> fila = new Fila<String>();
        fila.enfileirar("Tomate");
        fila.enfileirar("Cebola");
        fila.enfileirar("Alface");
        System.out.println(fila.desenfileirar());
        System.out.println(fila.desenfileirar());
        System.out.println(fila.desenfileirar());
        System.out.println(fila.desenfileirar());
    }
}
