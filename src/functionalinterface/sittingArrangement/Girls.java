package functionalinterface.sittingArrangement;

public class Girls implements Runnable {
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println("Girl");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
