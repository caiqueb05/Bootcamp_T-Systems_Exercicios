package Ex1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private Map<String, Aluno> alunos = new HashMap<>();

    public static void main(String[] args) {
        Main programa = new Main();
        programa.inicializaAlunos();
        programa.retornaNotaAluno("João");
        programa.exibirAlunosComNotaMaiorQue(6.0);
        programa.removerAlunoNotaMenorQue(6.0);
        Map<String, Aluno> alunosOrdenados = programa.classificarAlunosPorNotaDecrescente();
        alunosOrdenados.forEach((nome, aluno) -> System.out.println(nome + " - " + aluno.getNota()));
        Map<String, List<Aluno>> alunosAgrupadosPorNota = programa.agruparAlunosPorNota();

        for (Map.Entry<String, List<Aluno>> entrada : alunosAgrupadosPorNota.entrySet()) {
            System.out.println("Faixa de Nota: " + entrada.getKey());
            for (Aluno aluno : entrada.getValue()) {
                System.out.println("\t" + aluno.getNome() + " - " + aluno.getNota());
            }
        }
    }

    //    Ex 1
    private void inicializaAlunos() {
        alunos.put("João", new Aluno("João", 7.0));
        alunos.put("Maria", new Aluno("Maria", 8.0));
        alunos.put("José", new Aluno("José", 6.0));
        alunos.put("Ana", new Aluno("Ana", 9.0));
        alunos.put("Carlos", new Aluno("Carlos", 5.0));
        alunos.put("Mariana", new Aluno("Mariana", 100.0));
        alunos.put("Pedro", new Aluno("Pedro", 80.0));
        alunos.put("Paula", new Aluno("Paula", 70.0));
        alunos.put("Lucas", new Aluno("Lucas", 60.0));
        alunos.put("Juliana", new Aluno("Juliana", 50.0));

        for (Map.Entry<String, Aluno> aluno : alunos.entrySet()) {
            System.out.println(aluno.getKey() + " - " + aluno.getValue().getNota());
        }
    }

    //    Ex 2
    public void retornaNotaAluno(String nome) {
        if (alunos.containsKey(nome)) {
            System.out.println(alunos.get(nome).getNota());
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    public void exibirAlunosComNotaMaiorQue(double notaCorte) {
        alunos.entrySet().stream()
                .filter(aluno -> aluno.getValue().getNota() > notaCorte)
                .forEach(aluno -> System.out.println(aluno.getKey() + " - " + aluno.getValue().getNota()));
    }

    //    Ex 3
    public void removerAlunoNotaMenorQue(double notaCorte) {
        alunos.entrySet().stream()
                .filter(aluno -> aluno.getValue().getNota() < notaCorte)
                .forEach(aluno -> System.out.println("Removido: " + aluno.getKey() + " - " + aluno.getValue().getNota()));

        alunos.entrySet().removeIf(aluno -> aluno.getValue().getNota() < notaCorte);
    }

    //    Ex 4
    public Map<String, Aluno> classificarAlunosPorNotaDecrescente() {
        Comparator<Map.Entry<String, Aluno>> comparator = Map.Entry.<String, Aluno>comparingByValue(Comparator.comparingDouble(Aluno::getNota).reversed());

        return alunos.entrySet().stream()
                .sorted(comparator)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        () -> new LinkedHashMap<>()));
    }

    //    Ex 5
    public Map<String, List<Aluno>> agruparAlunosPorNota() {
        return alunos.values().stream()
                .collect(Collectors.groupingBy(aluno -> {
                    if (aluno.getNota() >= 90) return "A";
                    else if (aluno.getNota() >= 80) return "B";
                    else if (aluno.getNota() >= 70) return "C";
                    else if (aluno.getNota() >= 60) return "D";
                    else if (aluno.getNota() >= 50) return "E";
                    else return "F";
                }));
    }


}