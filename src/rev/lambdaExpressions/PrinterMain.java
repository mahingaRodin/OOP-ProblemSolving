package rev.lambdaExpressions;

@FunctionalInterface
interface  Printer {
    void print();
}

public abstract class PrinterMain {
    public static void main(String[] args) {
    Printer p = () -> {
        System.out.println("implementation using functional interface");
    };

    p.print();
    }

}
