package Ex6;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnalisadorDados<Double> analisador = new AnalisadorDados<>(
            linha -> Double.parseDouble(linha)
        );

        try {
            List<Double> dados = analisador.processarArquivo("caminho/para/o/arquivo.txt");
            analisador.exibirDados(dados);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
