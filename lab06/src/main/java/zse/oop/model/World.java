package zse.oop.model;

import zse.oop.OptionsParser;
import zse.oop.Simulation;

import java.util.List;

public class World {
    public static void main(String[] args) {

        List<Direction> directions;
        try {
            directions = OptionsParser.parse(args);
        } catch (IllegalArgumentException e) {
            System.out.println("Blad: " + e.getMessage());
            return;
        }

        List<Vector2d> positions = List.of(
                new Vector2d(2, 2),
                new Vector2d(2, 2),
                new Vector2d(3, 3)
        );

        WorldMap map = new GrassField(9);


        ConsoleMapDisplay display = new ConsoleMapDisplay();
        ((AbstractWorldMap) map).addListener(display);

        Simulation simulation = new Simulation(map, directions, positions);
        simulation.run();
    }
}
