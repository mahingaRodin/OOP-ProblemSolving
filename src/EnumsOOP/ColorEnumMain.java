package EnumsOOP;

public class ColorEnumMain {
    enum Colors {
        RED,
        BLUE,
        GREEN,
    }

    public static void main(String[] args) {
        for(Colors color : Colors.values()) {
            System.out.println(color);
        }
    }

}
