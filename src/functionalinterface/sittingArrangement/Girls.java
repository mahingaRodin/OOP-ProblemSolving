package functionalinterface.sittingArrangement;

public class Girls extends Thread {
    public void sitting() {
        for(int i=0; i<100; i++) {
            System.out.println("Girl");
        }
    }
}
