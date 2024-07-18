package ProcessamentoLog;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.Arrays;

public class ParallelLogProcessor {
    private final ExecutorService executor;

    public ParallelLogProcessor(int numberOfThreads) {
        this.executor = Executors.newFixedThreadPool(numberOfThreads);
    }

    public int processLogs(List<String> logFiles, String word) throws Exception {
        List<Callable<Integer>> tasks = logFiles.stream()
                .map(logFile -> (Callable<Integer>) () -> countOccurrencesInFile(logFile, word))
                .collect(Collectors.toList());

        List<Future<Integer>> results = executor.invokeAll(tasks);

        int totalOccurrences = 0;
        for (Future<Integer> result : results) {
            totalOccurrences += result.get();
        }

        executor.shutdown();
        return totalOccurrences;
    }

    private int countOccurrencesInFile(String logFile, String word) throws Exception {
        String content = Files.readString(Paths.get(logFile));
        int occurrences = (int) Arrays.stream(content.split("\\R"))
                .filter(line -> line.contains(word))
                .count();
        System.out.println("File " + logFile + " processed by " + Thread.currentThread().getName() + " with " + occurrences + " occurrences.");
        return occurrences;
    }
}