package EnumsOOP;

import java.util.EnumSet;

public class WeekdaysEnumSet {
    enum Days {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }

    public static void main(String[] args) {
        EnumSet<Days> weekdays = EnumSet.of(Days.MONDAY, Days.TUESDAY, Days.WEDNESDAY, Days.THURSDAY, Days.FRIDAY);
        System.out.println("Weekdays: " + weekdays);
    }
}
