package functionalinterface.executableFramework;

import java.util.ArrayList;
import java.util.List;
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
        List<CallableTaskA> messages = new ArrayList<>();
        messages.add(new CallableTaskA("Hello Year 2 A"));
        messages.add(new CallableTaskA("Hello Year 2 B"));
        messages.add(new CallableTaskA("Hello Year 2 C"));
        messages.add(new CallableTaskA("Hello Year 2 D"));

        List<Future<String>> msg = new ArrayList<>();

        for (CallableTaskA message : messages) {
            msg.add(executor.submit(message));
        }
        for(Future<String> megs : msg ) {
            System.out.println("Message: "+megs.get());
        }
        executor.shutdown();
        System.out.println("Rodin Did This !");
    }
}
