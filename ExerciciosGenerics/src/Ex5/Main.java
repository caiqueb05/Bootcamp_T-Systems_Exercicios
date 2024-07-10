package Ex5;

public class Main {
    public static void main(String[] args) {
        Vilao vilao = new Vilao("Coringa", "Matar o Batman.");
        Ajudante ajudante = new Ajudante("Harley Quinn", "Luta.");
        SuperHeroi superHeroi = new SuperHeroi("Batman", "Inteligência.");

        Personagem<Vilao> viloes = new Personagem<>();
        Personagem<Ajudante> ajudantes = new Personagem<>();
        Personagem<SuperHeroi> superHerois = new Personagem<>();

        viloes.adicionarMembro(vilao);
        ajudantes.adicionarMembro(ajudante);
        superHerois.adicionarMembro(superHeroi);

        System.out.println("Vilões:");
        for (Vilao v : viloes.getMembros()) {
            System.out.println("Nome: " + v.getNome() + " - Plano maligno: " + v.getPlanoMaligno());
        }

        System.out.println("\nAjudantes:");
        for (Ajudante a : ajudantes.getMembros()) {
            System.out.println("Nome: " + a.getNome() + " - Habilidade: " + a.getHabilidade());
        }

        System.out.println("\nSuper-heróis:");
        for (SuperHeroi s : superHerois.getMembros()) {
            System.out.println("Nome: " + s.getNome() + " - Poder: " + s.getPoder());
        }
    }
}
