package Ex4;

public class ComponenteRede<T> {
    private T componente;

    public ComponenteRede(T componente) {
        this.componente = componente;
    }

    public T getComponente() {
        return componente;
    }

    public void setComponente(T componente) {
        this.componente = componente;
    }
}
