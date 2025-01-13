package functionalinterface;

public class PrinterMain{
    public static void main(String[] args) {
        Printer p = (n1, n2) -> n1+n2;

        int sum = p.display(20,49);
        System.out.println(sum);
    }
}
