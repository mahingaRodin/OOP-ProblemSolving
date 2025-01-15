package functionalinterface.bankApp;

public class BankAccount {
    public Deposit deposit;
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public static void main(String[] args) {
    BankAccount bankAccount = new BankAccount(200000);
    }

    public synchronized void deposit(double amount) {
        this.balance += amount;
    }

    public synchronized void withdraw(int amount) {
        if(balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }



}
