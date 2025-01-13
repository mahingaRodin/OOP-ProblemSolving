package functionalinterface;

public class PrinterMain{
    public static void main(String[] args) {
        Printer p = (n1, n2) -> System.out.println(n1+n2);
        p.display(20, 20);
    }
}
