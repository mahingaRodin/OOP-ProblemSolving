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
public class ConsumerProducer {

}
