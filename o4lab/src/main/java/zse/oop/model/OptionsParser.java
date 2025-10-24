package zse.oop.model;

import java.util.*;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> result = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "f", "forward" -> result.add(MoveDirection.FORWARD);
                case "b", "backward" -> result.add(MoveDirection.BACKWARD);
                case "r", "right" -> result.add(MoveDirection.RIGHT);
                case "l", "left" -> result.add(MoveDirection.LEFT);
                default -> System.out.println("Ignorowany argument: " + arg);
            }
        }
        return result;
    }
}
