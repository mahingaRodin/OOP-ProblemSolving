package functionalinterface.threadCommunication;

class CounterA {
    int counter;
    boolean valueSet;

    public synchronized void put(int num) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Put: " + num);
        counter = num;
        valueSet = true;
        notify();
    }

    public synchronized void get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Get: " + counter);
        valueSet = false;
        notify();
    }
}

class ProducerA implements Runnable {
    CounterA counter;

    public ProducerA(CounterA counter) {
        this.counter = counter;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            counter.put(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class ConsumerA implements Runnable {
    CounterA counter;

    public ConsumerA(CounterA counter) {
        this.counter = counter;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while (true) {
            counter.get();
        }
    }
}

public class ConsumerProducer {
    public static void main(String[] args) {
        CounterA c = new CounterA();
        new ProducerA(c);
        new ConsumerA(c);
    }
}
