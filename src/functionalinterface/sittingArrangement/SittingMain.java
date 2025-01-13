package functionalinterface.sittingArrangement;

public class SittingMain {
    public static void main(String[] args) {
        Runnable Boys = new Boys();
        Runnable Girls = new Girls();

        Thread boys = new Thread(Boys);
        Thread girls = new Thread(Girls);
        boys.start();
        girls.start();
    }
}
