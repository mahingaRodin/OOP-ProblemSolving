package EnumsOOP;

public class ComparingEnums {
    enum Gender {
       MALE,
       FEMALE
    }

    public static void main(String[] args ) {
        Gender gender1 = Gender.MALE;
        Gender gender2 = Gender.FEMALE;

        if (gender1.ordinal() < gender2.ordinal()) {
            System.out.println(gender1 + " comes before " + gender2);
        } else if (gender1.ordinal() > gender2.ordinal()) {
            System.out.println(gender1 + " comes after " + gender2);
        } else {
            System.out.println(gender1 + " is the same as " + gender2);
        }
    }
}
