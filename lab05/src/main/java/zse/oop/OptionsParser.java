package zse.oop;

import zse.oop.model.Direction;
import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    public static List<Direction> parse(String[] args) {
        List<Direction> directions = new ArrayList<>();

        for (String arg : args) {
            switch (arg.toLowerCase()) {
                case "f", "forward" -> directions.add(Direction.FORWARD);
                case "b", "backward" -> directions.add(Direction.BACKWARD);
                case "r", "right" -> directions.add(Direction.RIGHT);
                case "l", "left" -> directions.add(Direction.LEFT);
                default -> System.out.println("Pominieto niepoprawny argument: " + arg);
            }
        }
        return directions;
    }
}
