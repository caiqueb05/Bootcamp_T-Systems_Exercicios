package SistemaBancario;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount(new Account(1000, 1));
        bank.addAccount(new Account(2000, 2));
        bank.addAccount(new Account(2000, 3));
        bank.addAccount(new Account(1500, 4));
        bank.addAccount(new Account(2500, 5));

        Thread t1 = new CustomerThread(bank, 1, 500, true);
        Thread t2 = new CustomerThread(bank, 1, 200, false);
        Thread t3 = new CustomerThread(bank, 2, 300, true);
        Thread t4 = new CustomerThread(bank, 2, 400, false);
        Thread t5 = new CustomerThread(bank, 3, 600, true);
        Thread t6 = new CustomerThread(bank, 3, 100, false);
        Thread t7 = new CustomerThread(bank, 4, 200, true);
        Thread t8 = new CustomerThread(bank, 4, 300, false);
        Thread t9 = new CustomerThread(bank, 5, 700, true);
        Thread t10 = new CustomerThread(bank, 5, 500, false);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Account 1 Balance: " + bank.getAccount(1).getBalance());
        System.out.println("Account 2 Balance: " + bank.getAccount(2).getBalance());
        System.out.println("Account 3 Balance: " + bank.getAccount(3).getBalance());
        System.out.println("Account 4 Balance: " + bank.getAccount(4).getBalance());
        System.out.println("Account 5 Balance: " + bank.getAccount(5).getBalance());

        bank.getAccount(1).printTransactionHistory();
        bank.getAccount(2).printTransactionHistory();
        bank.getAccount(3).printTransactionHistory();
        bank.getAccount(3).printTransactionHistory();
        bank.getAccount(4).printTransactionHistory();
        bank.getAccount(5).printTransactionHistory();
    }
}