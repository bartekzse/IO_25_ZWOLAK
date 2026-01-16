package zse.oop;

import zse.oop.model.*;
import java.util.List;

public class World {
    public static void main(String[] args) {
        List<Direction> moves = List.of(
                Direction.FORWARD, Direction.RIGHT, Direction.FORWARD,
                Direction.LEFT, Direction.BACKWARD, Direction.FORWARD
        );

        List<Vector2d> positions1 = List.of(new Vector2d(2,2), new Vector2d(3,3));
        List<Vector2d> positions2 = List.of(new Vector2d(0,0), new Vector2d(1,1));

        WorldMap map1 = new RectangularMap(5,5);
        WorldMap map2 = new GrassField(5);

        ConsoleMapDisplay display1 = new ConsoleMapDisplay();
        ConsoleMapDisplay display2 = new ConsoleMapDisplay();
        ((AbstractWorldMap) map1).addListener(display1);
        ((AbstractWorldMap) map2).addListener(display2);

        Simulation sim1 = new Simulation(map1, moves, positions1);
        Simulation sim2 = new Simulation(map2, moves, positions2);

        SimulationEngine engine = new SimulationEngine(List.of(sim1, sim2));

        System.out.println("=== SYNC ===");
        engine.runSync();

        System.out.println("=== ASYNC ===");
        engine.runAsync();

        System.out.println("=== ASYNC Thread Pool ===");
        engine.runAsyncInThreadPool();
        engine.awaitSimulationsEnd();

        System.out.println("System zakonczyl dzialanie");
    }
}
