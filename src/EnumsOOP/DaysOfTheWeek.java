package EnumsOOP;
/*
* A program that uses enum to print all days of the week!
* */
public class DaysOfTheWeek {
    enum Days {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    public static void main(String[] args) {
        for(Days days : Days.values()) {
            System.out.println(days);
        }
    }

}


//Challenge : Add the week type (weekday , weekend)