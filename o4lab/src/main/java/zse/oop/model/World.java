package zse.oop.model;

import java.util.List;
import java.util.stream.Collectors;

public class World {
    public static void main(String[] args) {
        String[] moves = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f"};

        List<MoveDirection> directions = OptionsParser.parse(moves);
        List<Vector2d> positions = List.of(
                new Vector2d(2, 2),
                new Vector2d(3, 4)
        );

        // 🔹 Tworzymy mapę o rozmiarze np. 5x5
        WorldMap map = new RectangularMap(5, 5);

        // 🔹 Tworzymy zwierzęta i umieszczamy je na mapie
        List<Animal> animals = positions.stream()
                .map(Animal::new)
                .peek(map::place)
                .collect(Collectors.toList());

        // 🔹 Tworzymy symulację z mapą i zwierzętami
        Simulation simulation = new Simulation(directions, animals, map);
        simulation.run();
    }
}
