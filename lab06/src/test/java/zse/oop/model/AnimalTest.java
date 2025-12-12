package zse.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void testRotation() {
        Animal a = new Animal(new Vector2d(2,2));

        a.move(Direction.RIGHT);
        assertEquals(MapDirection.EAST, a.getOrientation());

        a.move(Direction.RIGHT);
        assertEquals(MapDirection.SOUTH, a.getOrientation());

        a.move(Direction.LEFT);
        assertEquals(MapDirection.EAST, a.getOrientation());
    }

    @Test
    void testMoveForward() {
        GrassField map = new GrassField(0);
        Animal a = new Animal(new Vector2d(2,2));
        a.setMap(map);

        a.move(Direction.FORWARD);
        assertEquals(new Vector2d(2,3), a.getPosition());
    }

    @Test
    void testBlockedByAnimal() {
        GrassField map = new GrassField(0);

        Animal a1 = new Animal(new Vector2d(2,2));
        Animal a2 = new Animal(new Vector2d(2,3));

        map.place(a1);
        map.place(a2);

        a1.move(Direction.FORWARD); // powinien zostać zablokowany
        assertEquals(new Vector2d(2,2), a1.getPosition());
    }
}

