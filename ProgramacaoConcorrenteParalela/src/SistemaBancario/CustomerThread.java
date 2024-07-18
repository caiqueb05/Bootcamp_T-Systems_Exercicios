package SistemaBancario;

public class CustomerThread extends Thread {
    private Bank bank;
    private int accountNumber;
    private double amount;
    private boolean deposit;

    public CustomerThread(Bank bank, int accountNumber, double amount, boolean deposit) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.deposit = deposit;
    }

    @Override
    public void run() {
        if (deposit) {
            bank.getAccount(accountNumber).deposit(amount);
        } else {
            bank.getAccount(accountNumber).withdraw(amount);
        }
    }
}
