package Ex1;

import java.util.LinkedList;

public class Fila<T> {
    private LinkedList<T> elementos;

    public Fila() {
        this.elementos = new LinkedList<>();
    }

    public void enfileirar(T elemento) {
        elementos.addLast(elemento);
    }

    public T desenfileirar() {
        if (estaVazia()) {
            return null;
        }
        return elementos.removeFirst();
    }

    public boolean estaVazia() {
        return elementos.isEmpty();
    }
}
