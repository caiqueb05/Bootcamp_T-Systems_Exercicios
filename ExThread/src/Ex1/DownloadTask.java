package Ex1;

import static java.lang.Math.random;

public class DownloadTask extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Baixando arquivo...");
        try {
            Thread.sleep((long) (1000 * (Math.random()*10)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Download Concluido");
    }
}
