package zse.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    void precedesTest() {
        Vector2d v1 = new Vector2d(1, 1);
        Vector2d v2 = new Vector2d(2, 2);
        assertTrue(v1.precedes(v2));
        // test gdy nie jest precedes
        Vector2d v3 = new Vector2d(3, 0);
        assertFalse(v3.precedes(v2));
    }

    @Test
    void followsTest() {
        Vector2d v1 = new Vector2d(3, 3);
        Vector2d v2 = new Vector2d(2, 2);
        assertTrue(v1.follows(v2));
        // test gdy nie jest follows
        Vector2d v3 = new Vector2d(1, 4);
        assertFalse(v3.follows(v2));
    }

    @Test
    void toStringTest() {
        Vector2d v = new Vector2d(1, 2);
        assertEquals("(1,2)", v.toString());
    }

    @Test
    void addTest() {
        Vector2d v1 = new Vector2d(1, 2);
        Vector2d v2 = new Vector2d(3, 4);
        Vector2d result = v1.add(v2);
        assertEquals(new Vector2d(4, 6), result);
    }

    @Test
    void subtractTest() {
        Vector2d v1 = new Vector2d(5, 7);
        Vector2d v2 = new Vector2d(2, 3);
        Vector2d result = v1.subtract(v2);
        assertEquals(new Vector2d(3, 4), result);
    }

    @Test
    void upperRightTest() {
        Vector2d v1 = new Vector2d(1, 5);
        Vector2d v2 = new Vector2d(3, 3);
        Vector2d result = v1.upperRight(v2);
        assertEquals(new Vector2d(3, 5), result);
    }

    @Test
    void lowerLeftTest() {
        Vector2d v1 = new Vector2d(1, 5);
        Vector2d v2 = new Vector2d(3, 3);
        Vector2d result = v1.lowerLeft(v2);
        assertEquals(new Vector2d(1, 3), result);
    }

    @Test
    void oppositeTest() {
        Vector2d v = new Vector2d(1, -2);
        Vector2d result = v.opposite();
        assertEquals(new Vector2d(-1, 2), result);
    }

    @Test
    void equalsTest() {
        Vector2d v1 = new Vector2d(2, 3);
        Vector2d v2 = new Vector2d(2, 3);
        Vector2d v3 = new Vector2d(3, 2);
        assertTrue(v1.equals(v2));
        assertFalse(v1.equals(v3));
        assertFalse(v1.equals(null));
        assertFalse(v1.equals("some string"));
    }

    @Test
    void hashCodeTest() {
        Vector2d v1 = new Vector2d(2, 3);
        Vector2d v2 = new Vector2d(2, 3);
        assertEquals(v1.hashCode(), v2.hashCode());
    }
}
