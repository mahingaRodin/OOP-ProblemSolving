package functionalinterface.sittingArrangement;

public class Girls extends Thread {
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println("Girl");
        }
    }
}
