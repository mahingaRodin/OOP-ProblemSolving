package functionalinterface;

public class PrinterMain{
    public static void main(String[] args) {
        Printer p = () -> System.out.println("the implementation");
        p.display();
    }
}
