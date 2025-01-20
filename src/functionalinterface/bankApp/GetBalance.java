package functionalinterface.bankApp;

public class GetBalance {
    private int balance;

    public GetBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}