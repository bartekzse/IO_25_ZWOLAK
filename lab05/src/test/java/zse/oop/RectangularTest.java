package zse.oop;

import org.junit.jupiter.api.Test;
import zse.oop.model.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularTest {

    @Test
    void testFullSimulation() {
        RectangularMap map = new RectangularMap(5, 5);

        List<Vector2d> positions = List.of(
                new Vector2d(1, 1),
                new Vector2d(2, 2)
        );

        List<Direction> moves = List.of(
                Direction.FORWARD, Direction.RIGHT, Direction.FORWARD,
                Direction.LEFT, Direction.BACKWARD
        );

        Simulation simulation = new Simulation(map, moves, positions);

        simulation.run();

        Animal first = simulation.getAnimals().get(0);
        Animal second = simulation.getAnimals().get(1);

        assertTrue(first.getPosition().precedes(new Vector2d(4, 4)) &&
                        first.getPosition().follows(new Vector2d(0, 0)),
                "Pierwsze zwierzę wciąż w granicach mapy");

        assertTrue(second.getPosition().precedes(new Vector2d(4, 4)) &&
                        second.getPosition().follows(new Vector2d(0, 0)),
                "Drugie zwierzę wciąż w granicach mapy");

        assertNotEquals(first.getPosition(), second.getPosition(),
                "Zwierzęta nie mogą być na tej samej pozycji");

        assertTrue(map.isOccupied(first.getPosition()), "Pierwsze zwierzę jest na swojej pozycji");
        assertTrue(map.isOccupied(second.getPosition()), "Drugie zwierzę jest na swojej pozycji");

        assertEquals(first, map.objectAt(first.getPosition()));
        assertEquals(second, map.objectAt(second.getPosition()));

        String mapString = map.toString();
        assertTrue(mapString.contains(first.toString()));
        assertTrue(mapString.contains(second.toString()));
    }
}
