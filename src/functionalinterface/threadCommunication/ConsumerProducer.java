package functionalinterface.threadCommunication;

class  CounterA {
    int counter;
    public void put(int num) {
        System.out.println("Put: "+ num);
        counter = num;
    }
    public void get() {
        System.out.println("Get: " + counter);
    }
}
class ProducerA implements Runnable {
    CounterA counter;
    public ProducerA(CounterA counter) {
        this.counter = counter;
    }
    @Override
    public void run() {

    }
}
public class ConsumerProducer {

}
