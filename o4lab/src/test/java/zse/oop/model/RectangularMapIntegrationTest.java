package zse.oop.model;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapIntegrationTest {

    @Test
    void testMovementOnMap() {
        WorldMap map = new RectangularMap(5, 5);
        Animal a1 = new Animal(new Vector2d(2, 2));
        Animal a2 = new Animal(new Vector2d(3, 3));

        assertTrue(map.place(a1));
        assertTrue(map.place(a2));
        assertFalse(map.place(new Animal(new Vector2d(2, 2)))); // nie może być dwa na jednym polu

        Simulation sim = new Simulation(
                List.of(MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD),
                List.of(a1, a2),
                map
        );

        sim.run();

        // po ruchach sprawdzamy czy nie wychodzą poza mapę
        assertTrue(a1.getPosition().getX() >= 0 && a1.getPosition().getX() < 5);
        assertTrue(a1.getPosition().getY() >= 0 && a1.getPosition().getY() < 5);
    }
}
