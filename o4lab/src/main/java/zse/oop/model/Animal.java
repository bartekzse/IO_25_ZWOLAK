package zse.oop.model;

public class Animal {

    private Vector2d position;
    private MapDirection orientation = MapDirection.NORTH;

    public Animal(Vector2d initialPosition) {
        this.position = initialPosition;
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public void move(MoveDirection direction, MoveValidator validator) {
        Vector2d newPosition = position;

        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> newPosition = position.add(orientation.toUnitVector());
            case BACKWARD -> newPosition = position.subtract(orientation.toUnitVector());
        }

        if (validator.canMoveTo(newPosition)) {
            position = newPosition;
        }
    }

    @Override
    public String toString() {
        return switch (orientation) {
            case NORTH -> "^";
            case SOUTH -> "v";
            case EAST -> ">";
            case WEST -> "<";
        };
    }
}
