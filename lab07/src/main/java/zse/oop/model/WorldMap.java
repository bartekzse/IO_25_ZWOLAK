package zse.oop.model;

import java.util.Collection;
import java.util.UUID;

public interface WorldMap extends MoveValidator {

    boolean place(Animal animal) throws PositionAlreadyOccupiedException;

    void move(Animal animal, Direction direction);

    boolean isOccupied(Vector2d position);

    WorldElement objectAt(Vector2d position);

    Collection<WorldElement> getElements();

    Boundary getCurrentBounds();

    UUID getId(); // unikalny identyfikator mapy
}
