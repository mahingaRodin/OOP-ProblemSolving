package functionalinterface;

public class ProcessMain {
    public static void main(String[] args) {
        StringProcessor toUpperCase = input -> input.toUpperCase();
        System.out.println(toUpperCase.process("hello"));

        StringProcessor reverseString = input -> new StringBuilder(input).reverse().toString();
        System.out.println(reverseString.process("rodin"));
    }
}
