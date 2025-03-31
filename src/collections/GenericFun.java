package collections;

public class GenericFun {
    public static <T> void printArr(T[] arr) {
        for(T ele : arr) {
            System.out.println(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArr = {1,3,5,6,78,9};
        String[] strArr = {"one","two","three","four","five"};
        printArr(intArr);
        printArr(strArr);

    }
}
