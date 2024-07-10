package Ex4;

import java.util.ArrayList;
import java.util.List;

public class Rede<T> {
    private List<ComponenteRede<T>> componentes;

    public Rede() {
        this.componentes = new ArrayList<>();
    }

    public void adicionarComponente(ComponenteRede<T> componente) {
        componentes.add(componente);
    }

    public void removerComponente(ComponenteRede<T> componente) {
        componentes.remove(componente);
    }

    public int getQuantidadeComponentes() {
        return componentes.size();
    }

    public void simular() {
        System.out.println("Simulando rede com " + getQuantidadeComponentes() + " componentes.");
    }
}