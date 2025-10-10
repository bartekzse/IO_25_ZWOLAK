package zse.oop.model;

import java.util.List;

public class World {
    public static void main(String[] args) {
        String[] moves = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f"};

        List<MoveDirection> directions = OptionsParser.parse(moves);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

        Simulation simulation = new Simulation(directions, positions);
        simulation.run();
    }
}
