package EnumsOOP;

public class SwitchCase {
    enum Days {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY;
        }

        public  static void main(String[] args) {
        Days days = Days.MONDAY;
        switch (days){
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> {
                System.out.println("Weekday");
                break;
            }
            case SATURDAY ,SUNDAY -> System.out.println("Weekend");
        }
        }
    }

    //Add a list of tasks to be done on each day

