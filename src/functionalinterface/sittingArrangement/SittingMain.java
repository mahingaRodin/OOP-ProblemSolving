package functionalinterface.sittingArrangement;

public class SittingMain {
    public static void main(String[] args) {
        Boys boys = new Boys();
        Girls girls = new Girls();
        boys.start();
        girls.start();
    }
}
