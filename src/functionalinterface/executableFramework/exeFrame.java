package functionalinterface.executableFramework;


class BoyA implements Runnable {
    @Override
    public void run() {
        System.out.println("Boy thread has started. ");
        for(int i=0; i<=100; i++) {
            System.out.println("Boy: "+i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Boy thread has completed!");
    }
}




public class exeFrame {
}
