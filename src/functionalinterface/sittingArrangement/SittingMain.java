package functionalinterface.sittingArrangement;

public class SittingMain {
    public static void main(String[] args) {

        Counter c = new Counter();
        Runnable Boys = () -> {
            for(int i=0; i<1000; i++) {
                c.increment();
            }
        };
        Runnable Girls = () -> {
            for(int i=0; i<1000; i++) {
                c.increment();
            }
        };

        Thread boys = new Thread(Boys);
        Thread girls = new Thread(Girls);
        boys.start();
        girls.start();
        try{
            boys.join();
            girls.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("current value: " + c.counter);
    }
}
