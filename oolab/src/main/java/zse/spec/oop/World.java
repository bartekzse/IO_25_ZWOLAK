package zse.spec.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");

        Direction[] directions = parseArgs(args);
        run(directions);

        System.out.println("system zakończył działanie");
    }

    static Direction[] parseArgs(String[] args) {
        return java.util.Arrays.stream(args)
                .map(arg -> {
                    switch (arg) {
                        case "f":
                            return Direction.FORWARD;
                        case "b":
                            return Direction.BACKWARD;
                        case "r":
                            return Direction.RIGHT;
                        case "l":
                            return Direction.LEFT;
                        default:
                            return null;
                    }
                })
                .filter(d -> d != null)
                .toArray(Direction[]::new);
    }

    static void run(Direction[] directions) {
        for (Direction direction : directions) {
            switch (direction) {
                case FORWARD:
                    System.out.println("zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("zwierzak idzie do tylu");
                    break;
                case RIGHT:
                    System.out.println("zwierzak skreca w prawo");
                    break;
                case LEFT:
                    System.out.println("zwierzak idzie w lewo");
                    break;
            }
        }
    }
}