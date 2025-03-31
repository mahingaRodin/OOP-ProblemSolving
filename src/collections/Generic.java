package collections;
//defining the generic class
class Box<T> {
    private T val;

    public void setVal(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }
}

public class Generic {
public static void main(String[] args) {
    Box<Integer> box = new Box<>();
    box.setVal(150);
    System.out.println(box.getVal());

    Box<String> box1 = new Box<>();
    box1.setVal("Hello");
    System.out.println(box1.getVal());
}
}
