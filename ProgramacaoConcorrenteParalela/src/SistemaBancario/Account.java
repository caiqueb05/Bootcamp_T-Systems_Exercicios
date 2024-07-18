package SistemaBancario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private int accountNumber;
    private List<Transaction> transactions;

    public Account(double balance, int accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.transactions = new ArrayList<>();
    }

    public void printTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("There's no transaction for account number: " + accountNumber);
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Transactions History for Account Number: " + accountNumber);
        for (Transaction transaction : transactions) {
            String dateStr = sdf.format(transaction.getDate());
            System.out.println(dateStr + " - " + transaction.getType() + " - " + transaction.getAmount());
        }
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public synchronized void withdraw(double amount) {
        balance -= amount;
        transactions.add(new Transaction("Withdraw", amount));
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
