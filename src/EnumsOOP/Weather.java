package EnumsOOP;

public class Weather {
    enum Seasons {
        SPRING("Warm Season"),
        SUMMER("Hot Season"),
        AUTUMN("Cool Season"),
        WINTER("Cold Season");

        private final String description;

        Seasons(String description) {
            this.description = description;
        }

        public  String getDescription() {
            return  description;
        }
    }

    public static void main(String[] args) {
        for(Seasons season : Seasons.values()) {
            System.out.println("The season is " + season + " described as a " + season.getDescription());
        }
    }
}

//Challenge : Add seasonal activities
