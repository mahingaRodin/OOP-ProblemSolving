package functionalinterface;

public class PrinterMain{
    public static void main(String[] args) {
        Printer p = new Printer() {
            @Override
            public void display() {
                System.out.println("the implementation");
            }
        };
        p.display();
    }
}
