package rev.lambdaExpressions;

public class PrinterMain {
    public static void main(String[] args) {
        Printer p = () -> System.out.println("used functional interface");
        p.print();
}
}
