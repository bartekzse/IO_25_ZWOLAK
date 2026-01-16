package zse.oop;

import org.junit.jupiter.api.Test;
import zse.oop.model.Direction;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void testParseValidDirections() {
        String[] args = {"f", "b", "r", "l", "forward"};
        List<Direction> result = OptionsParser.parse(args);

        assertEquals(5, result.size());
        assertEquals(Direction.FORWARD, result.get(0));
        assertEquals(Direction.LEFT, result.get(3));
        assertEquals(Direction.RIGHT, result.get(2));
    }

    @Test
    void testParseInvalidDirections() {
        String[] args = {"x", "forward", "test"};
        List<Direction> result = OptionsParser.parse(args);

        assertEquals(1, result.size());
        assertEquals(Direction.FORWARD, result.get(0));
    }
}
