package zse.oop.model;

import zse.oop.OptionsParser;
import zse.oop.Simulation;

import java.util.List;

public class World {
    public static void main(String[] args) {
        List<Direction> directions = OptionsParser.parse(args);

        List<Vector2d> animalPositions = List.of(
                new Vector2d(2, 2),
                new Vector2d(3, 4)
        );

        // Ustawienie trawy w trzech konkretnych miejscach
        List<Vector2d> grassPositions = List.of(
                new Vector2d(0, 0),
                new Vector2d(5, 5),
                new Vector2d(2, 3)
        );

        GrassField map = new GrassField(grassPositions);

        Simulation simulation = new Simulation(map, directions, animalPositions);
        simulation.run();
        System.out.println(map);
    }
}
