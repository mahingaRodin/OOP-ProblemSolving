package functionalinterface.bankApp;

public class Withdraw extends Thread {
    private BankAccount bankAccount;
    private int amount;

    public Withdraw(BankAccount bankAccount, int amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        bankAccount.withdraw(amount);
    }
}