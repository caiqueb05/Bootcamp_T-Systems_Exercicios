package ProcessamentoLog;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ParallelLogProcessor processor = new ParallelLogProcessor(Runtime.getRuntime().availableProcessors());
            List<String> logFiles = Arrays.asList("src/processamentolog/logfiles/log1.txt", "src/processamentolog/logfiles/log2.txt", "src/processamentolog/logfiles/log3.txt");
            String word = "Caique";
            int totalOccurrences = processor.processLogs(logFiles, word);
            System.out.println("Total occurrences of the word " + word + ": " + totalOccurrences);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}