package zse.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zse.oop.model.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    private List<Vector2d> positions;

    @BeforeEach
    void setup() {
        positions = List.of(
                new Vector2d(2, 2),
                new Vector2d(3, 4)
        );
    }

    @Test
    void testAnimalsAlternateMoves() {
        List<Direction> directions = List.of(
                Direction.FORWARD, Direction.BACKWARD, Direction.RIGHT, Direction.LEFT
        );

        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(map, directions, positions);
        simulation.run();

        Animal first = simulation.getAnimals().get(0);
        Animal second = simulation.getAnimals().get(1);

        assertEquals(new Vector2d(2, 3), first.getPosition());
        assertEquals(new Vector2d(3, 3), second.getPosition());
    }

    @Test
    void testAnimalStaysWithinBounds() {
        List<Direction> directions = List.of(
                Direction.FORWARD, Direction.FORWARD, Direction.FORWARD,
                Direction.FORWARD, Direction.FORWARD, Direction.FORWARD
        );

        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(map, directions, List.of(new Vector2d(2, 4)));
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);

        assertTrue(animal.getPosition().precedes(new Vector2d(4, 4)));
        assertTrue(animal.getPosition().follows(new Vector2d(0, 0)));
    }

    @Test
    void testOrientationChangesCorrectly() {
        List<Direction> directions = List.of(Direction.RIGHT, Direction.RIGHT, Direction.LEFT);

        RectangularMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(map, directions, List.of(new Vector2d(2, 2)));
        simulation.run();

        Animal animal = simulation.getAnimals().get(0);
        assertEquals(MapDirection.EAST, animal.getOrientation());
    }

    @Test
    void testOptionsParserValidInput() {
        String[] args = {"f", "b", "r", "l", "x", "forward"};
        List<Direction> result = OptionsParser.parse(args);

        assertEquals(5, result.size());
        assertEquals(Direction.FORWARD, result.get(0));
        assertEquals(Direction.LEFT, result.get(3));
    }

    @Test
    void testOptionsParserInvalidInput() {
        String[] args = {"bad", "123", " "};
        List<Direction> result = OptionsParser.parse(args);

        assertTrue(result.isEmpty());
    }
}
