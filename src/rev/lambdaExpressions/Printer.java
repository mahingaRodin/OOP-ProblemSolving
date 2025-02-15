package rev.lambdaExpressions;

public abstract class Printer {
    public static void main(String[] args) {
        Printer p = new Printer() {
            @Override
            public void print() {
                System.out.println("implementation of interface using anonymous class!!");
            }
        };
    }

    public abstract void print();
}
