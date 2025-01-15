package functionalinterface.bankApp;

public class Deposit extends Thread {
    private BankAccount bankAccount;
    private double amount;
    public Deposit(BankAccount bankAccount, double amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        bankAccount.deposit(amount);
    }
}
