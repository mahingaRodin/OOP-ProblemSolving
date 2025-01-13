package functionalinterface;

public class PrinterMain{
    public static void main(String[] args) {
        Printer p = (message, name) -> System.out.println(message + " " + name);
        p.display("Hello", "Rodin");
    }
}
