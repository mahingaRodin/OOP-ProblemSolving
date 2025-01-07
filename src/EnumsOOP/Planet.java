package EnumsOOP;

public class Planet {
    enum Planets {
        MERCURY,
        EARTH,
        VENUS,
        MARS;

        public boolean isHabitable() {
            return this == EARTH;
    }


    }

    public  static void main(String[] args) {
        Planets planet = Planets.EARTH;
        System.out.println(planet + "is habitable " + planet.isHabitable());
    }

}

//Challenge : Add the description for each planet.
