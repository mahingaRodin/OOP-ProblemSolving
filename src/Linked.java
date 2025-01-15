import java.util.LinkedList;

public class Linked {
    public static void main(String[] args) {
        LinkedList<String> districts = new LinkedList<String>();
        districts.add("Musanze");
        districts.add("Nyabihu");
        for(String district:districts) {
            System.out.println(district);
        }
        districts.addFirst("Rubavu");
        districts.addLast("Kayonza");
        System.out.println("After: ");
        for(String district:districts) {
            System.out.println(district);
        }
    }
}
