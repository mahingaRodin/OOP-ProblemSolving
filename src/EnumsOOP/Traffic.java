package EnumsOOP;

public class Traffic {

    enum Action {
        GO,
        STOP,
        GET_READY
    }
    enum TrafficLight {
        RED(Action.STOP),
        YELLOW(Action.GET_READY),
        GREEN(Action.GO);

        public final Action action;

        TrafficLight(Action action) {
            this.action = action;
        }

        public Action getAction() {
           return  action;
        }
    }

    public static void main(String[] args) {
        TrafficLight light = TrafficLight.GREEN;
        System.out.println(light +" : "+ light.getAction());
    }

}
