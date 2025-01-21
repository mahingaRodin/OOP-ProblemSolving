package functionalinterface.executableFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    int num;

    public Task(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("Task number: "+num+" has started");
        for(int i = num; i < num*5; i++) {
            System.out.print("  "+num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Task number: "+num+" has completed");
    }
}

public class exeFrame {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i = 1; i <= 10; i++) {
            executor.execute(new Task(i));
        }
        executor.shutdown();
    }
}