package rev.enums;

public class Enum {
    enum Laptop {
        HP(300),
        THINK_PAD(2000),
        DELL(100),
        MACBOOK;

        private int price;
        private Laptop(int price) {
            this.price = price;
        }

        private Laptop() {

        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    public static  void main(String[] args) {
        Laptop p = Laptop.MACBOOK;
        p.setPrice(400);
        System.out.println("The price of the Laptop is: " + p.name() + Laptop.HP.getPrice());
        for(Laptop lp: Laptop.values()) {
            System.out.println(lp.name()+ " " + lp.getPrice());
        }
    }
}
