package Ex5;

import java.util.ArrayList;
import java.util.List;

public class Personagem<T> {
    private List<T> membros;

    public Personagem() {
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(T membro) {
        membros.add(membro);
    }

    public boolean removerMembro(T membro) {
        return membros.remove(membro);
    }

    public List<T> getMembros() {
        return membros;
    }
}