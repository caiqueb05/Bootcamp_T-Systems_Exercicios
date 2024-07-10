package Ex4;

public class GerenciadorRedes {

    public static void main(String[] args) {
        Rede<String> redeLocal = new Rede<>();
        redeLocal.adicionarComponente(new ComponenteRede<>("Roteador"));
        redeLocal.adicionarComponente(new ComponenteRede<>("Switch"));
        redeLocal.simular();

        Rede<String> redeSemFio = new Rede<>();
        redeSemFio.adicionarComponente(new ComponenteRede<>("Access Point"));
        redeSemFio.adicionarComponente(new ComponenteRede<>("Dispositivo Móvel"));
        redeSemFio.simular();

        Rede<String> redeWAN = new Rede<>();
        redeWAN.adicionarComponente(new ComponenteRede<>("Roteador WAN"));
        redeWAN.adicionarComponente(new ComponenteRede<>("Firewall"));
        redeWAN.simular();
    }
}
