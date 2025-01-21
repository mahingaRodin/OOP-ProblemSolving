package functionalinterface.executableFramework;

import java.util.concurrent.*;

class CallableTaskA implements Callable<String> {
    String message;
    public CallableTaskA(String message) {
        this.message = message;
    }

    @Override
    public String call() throws Exception {
        return message;
    }
}


public class CallableTask{
    public static void main(String []a) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> msg = executor.submit(new CallableTaskA("Hello Year 2 A"));
        String message = msg.get();
        System.out.println("message is: " +message);
    }
}
