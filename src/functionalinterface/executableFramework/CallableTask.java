package functionalinterface.executableFramework;

import java.util.List;
import java.util.concurrent.*;

class CallableTaskA implements Callable<String> {
    String message;

    public CallableTaskA(String message) {
        this.message = message;
    }

    @Override
    public String call() throws Exception {
        // Simulate some processing time
        Thread.sleep((long) (Math.random() * 1000)); // Random sleep to simulate work
        return message;
    }
}

public class CallableTask {
    public static void main(String[] a) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Using invokeAny with a list of tasks
        String result = executor.invokeAny(List.of(
                new CallableTaskA("Hello Year 2 A"),
                new CallableTaskA("Hello Year 2 B"),
                new CallableTaskA("Hello Year 2 C"),
                new CallableTaskA("Hello Year 2 D"),
                new CallableTaskA("Hello Rca")
        ));

        executor.shutdown();
        System.out.println("First Completed Task Message: " + result);
        System.out.println("Rodin Did This !");
    }
}
