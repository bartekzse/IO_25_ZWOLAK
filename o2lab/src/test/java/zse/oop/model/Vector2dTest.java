package zse.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        assertEquals("(1,2)", new Vector2d(1,2).toString());
    }

    @Test
    void testEquals() {
        assertEquals(new Vector2d(1,2), new Vector2d(1,2));
        assertNotEquals(new Vector2d(1,2), new Vector2d(2,1));
    }

    @Test
    void testPrecedes() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,3);
        assertTrue(v1.precedes(v2));
        assertFalse(v2.precedes(v1));
    }

    @Test
    void testFollows() {
        Vector2d v1 = new Vector2d(3,4);
        Vector2d v2 = new Vector2d(2,3);
        assertTrue(v1.follows(v2));
        assertFalse(v2.follows(v1));
    }

    @Test
    void testAdd() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(3,4);
        assertEquals(new Vector2d(4,6), v1.add(v2));
    }

    @Test
    void testSubtract() {
        Vector2d v1 = new Vector2d(5,5);
        Vector2d v2 = new Vector2d(2,3);
        assertEquals(new Vector2d(3,2), v1.subtract(v2));
    }

    @Test
    void testUpperRight() {
        Vector2d v1 = new Vector2d(1,5);
        Vector2d v2 = new Vector2d(3,2);
        assertEquals(new Vector2d(3,5), v1.upperRight(v2));
    }

    @Test
    void testLowerLeft() {
        Vector2d v1 = new Vector2d(1,5);
        Vector2d v2 = new Vector2d(3,2);
        assertEquals(new Vector2d(1,2), v1.lowerLeft(v2));
    }

    @Test
    void testOpposite() {
        assertEquals(new Vector2d(-2, -3), new Vector2d(2, 3).opposite());
    }
}
