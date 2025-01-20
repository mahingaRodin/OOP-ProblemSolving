package functionalinterface.bankApp;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(200000);

        // Using lambda expressions for thread creation
        Runnable withdrawTask = () -> new Withdraw(bankAccount, 500).start();
        Runnable depositTask = () -> new Deposit(bankAccount, 300).start();

        new Thread(withdrawTask).start();
        new Thread(depositTask).start();
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}