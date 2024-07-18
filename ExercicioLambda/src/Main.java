import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 2, 3, 4, 5);
        List<String> palavras = Arrays.asList("comida", "janela", "avião", "paralelepípedo");
        List<String> pessoas = Arrays.asList("João", "Maria", "José");
        List<Integer> idade = Arrays.asList(20, 30, 40);

        // Ex1
        numeros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
        System.out.println();

        // Ex2
        List<Integer> numerosDobrados = numeros.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(numerosDobrados);
        System.out.println();

        // Ex3
        numeros.stream().allMatch(n -> n > 2);

        // Ex4
        numeros.stream().max(Integer::compareTo).ifPresent(System.out::println);
        System.out.println();

        // Ex5
        palavras.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println();

        // Ex6
        palavras.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
        System.out.println();

        // Ex7
        Map<Integer, List<String>> pessoasAgrupadasPorIdade = IntStream.range(0, pessoas.size())
                .boxed()
                .collect(Collectors.groupingBy(
                        idade::get,
                        Collectors.mapping(pessoas::get, Collectors.toList())
                ));

        pessoasAgrupadasPorIdade.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println();

        // Ex8
        double media = numeros.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(media);
        System.out.println();

        // Ex9
        numeros.stream().distinct().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Ex10
        List<Object> combinada = IntStream.range(0, Math.max(numeros.size(), palavras.size()))
                .boxed()
                .flatMap(i -> Arrays.stream(new Object[]{
                        i < numeros.size() ? numeros.get(i) : null,
                        i < palavras.size() ? palavras.get(i) : null
                }))
                .filter(obj -> obj != null)
                .collect(Collectors.toList());

        System.out.println(combinada);
    }


}