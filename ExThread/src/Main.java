import Ex1.DownloadTask;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DownloadTask downloadTask1 = new DownloadTask();
        downloadTask1.start();
        DownloadTask downloadTask2 = new DownloadTask();
        downloadTask2.start();
        DownloadTask downloadTask3 = new DownloadTask();
        downloadTask3.start();
        DownloadTask downloadTask4 = new DownloadTask();
        downloadTask4.start();

        try {
            downloadTask1.join();
            downloadTask2.join();
            downloadTask3.join();
            downloadTask4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Threads Concluídas");
    }
}