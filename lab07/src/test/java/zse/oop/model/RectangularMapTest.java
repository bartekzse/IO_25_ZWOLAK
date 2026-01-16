package zse.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void testCanMoveInsideBounds() {
        RectangularMap map = new RectangularMap(5,5);
        assertTrue(map.canMoveTo(new Vector2d(3,3)));
    }

    @Test
    void testCannotMoveOutsideBounds() {
        RectangularMap map = new RectangularMap(5,5);
        assertFalse(map.canMoveTo(new Vector2d(6,2)));
        assertFalse(map.canMoveTo(new Vector2d(1,-1)));
    }

    @Test
    void testPlaceAnimal() {
        RectangularMap map = new RectangularMap(5,5);
        Animal a = new Animal(new Vector2d(2,2));

        assertTrue(map.place(a));
        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertEquals(a, map.objectAt(new Vector2d(2,2)));
    }
}
