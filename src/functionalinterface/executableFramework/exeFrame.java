package functionalinterface.executableFramework;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

class GirlA implements Runnable {
    @Override
    public void run() {
        System.out.println("Girl thread has started. ");
        for(int i=0; i<=100; i++) {
            System.out.println("Girl: "+i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Girl thread has completed!");
    }
}

class TeacherA implements Runnable {
    @Override
    public void run() {
        System.out.println("Teacher thread has started. ");
        for(int i=0; i<=100; i++) {
            System.out.println("Teacher: "+i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Teacher thread has completed!");
    }
    }


public class exeFrame {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new BoyA());
        executor.execute(new GirlA());
        executor.execute(new TeacherA());
        executor.shutdown();
        for(int i=0; i<5; i++) {
            System.out.println("main values: "+i );
        }
    }
}
