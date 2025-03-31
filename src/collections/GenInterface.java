package collections;
interface Data<T> {
    void setData(T data);
    T getData();
}

class StringData implements Data<String> {
    private String data;
    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
}

public class GenInterface {
    public static void main(String[] args) {
        Data<String> data = new StringData();
        data.setData("Generics in OOP");
        System.out.println(data.getData());
    }
}
