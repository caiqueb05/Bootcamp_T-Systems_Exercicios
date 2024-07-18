package ProcessamentoLog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class LogProcessor implements Callable<Integer> {
    private String filePath;
    private String word;

    public LogProcessor(String filePath, String word) {
        this.filePath = filePath;
        this.word = word;
    }

    @Override
    public Integer call() {
        int count = 0;
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] words = content.split("\\s+");
            for (String w : words) {
                if (w.equals(word)) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
