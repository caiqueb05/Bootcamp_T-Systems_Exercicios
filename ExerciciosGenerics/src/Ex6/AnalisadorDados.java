package Ex6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;

public class AnalisadorDados<T> {
    private Function<String, T> processador;

    public AnalisadorDados(Function<String, T> processador) {
        this.processador = processador;
    }

    public List<T> processarArquivo(String caminhoArquivo) throws IOException {
        return Files.lines(Paths.get(caminhoArquivo))
                    .map(processador)
                    .toList();
    }

    public void exibirDados(List<T> dados) {
        dados.forEach(System.out::println);
    }
}