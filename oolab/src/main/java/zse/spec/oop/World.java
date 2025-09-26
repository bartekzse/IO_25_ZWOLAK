package zse.spec.oop;

import static java.lang.System.out;

public class World {
    public static void main(String[] args){
        out.println("system wystartowal");
        Direction[] directions = new Direction[args.length];
        for(int i = 0; i < args.length; i++){
            switch (args[i]){
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACKWARD;
                case "r" -> directions[i] = Direction.RIGHT;
                case "l" -> directions[i] = Direction.LEFT;
            }
        }
        run(directions);
        out.println("system zakonczyl dzialanie");

    }

    static void run(Direction[] direction){
        for(Direction elements : direction){
            switch (elements) {
                case FORWARD:
                    out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    out.println("Zwierzak idzie do tylu");
                    break;
                case LEFT:
                    out.println("Zwierzak idzie w lewo");
                    break;
                case RIGHT:
                    out.println("Zwierzak idzie w prawo");
                    break;
                default:
                    out.println("NIE MA TAKIEJ");
                    break;
            }
        }

    }
//    static void run(String[] args){
//        out.println("Zwierzak idzie do przodu");
//        out.println(String.join(", ",args));
//        for(String  elements : args){
//            switch (elements){
//                case "f":
//                    out.println("zwierzak idzie do przodu");
//                    break;
//                case "b":
//                    out.println("zwierzak idzie do tylu");
//                    break;
//                case "l":
//                    out.println("zwierzak idzie w lewo");
//                    break;
//                case "r":
//                    out.println("zwierzak idzie w prawo");
//                    break;
//            }
//        }
//
//    }
}
