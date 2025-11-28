package zse.oop.model;

public class Animal implements WorldElement {
    private Vector2d position;
    private MapDirection orientation;
    private MoveValidator map;

    public Animal(Vector2d initialPosition) {
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public void setMap(MoveValidator map) {
        this.map = map;
    }

    public void move(Direction direction) {
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD, BACKWARD -> {
                Vector2d moveVector = orientation.toUnitVector();
                if (direction == Direction.BACKWARD) {
                    moveVector = moveVector.opposite();
                }
                Vector2d newPos = position.add(moveVector);

                if (map != null && map.canMoveTo(newPos)) {
                    position = newPos;
                }
            }
        }
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return switch (orientation) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }
}
