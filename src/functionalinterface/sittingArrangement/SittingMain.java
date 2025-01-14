package functionalinterface.sittingArrangement;

public class SittingMain {
    public static void main(String[] args) {
        Runnable Boys = () -> {
            for(int i=0; i<100; i++) {
                System.out.println("Boy");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable Girls = () -> {
            for(int i=0; i<100; i++) {
                System.out.println("Girl");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread boys = new Thread(Boys);
        Thread girls = new Thread(Girls);
        boys.start();
        girls.start();
    }
}
