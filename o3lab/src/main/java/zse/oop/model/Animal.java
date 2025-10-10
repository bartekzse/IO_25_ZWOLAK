package zse.oop.model;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public Animal() {}

    public Animal(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public boolean isAt(Vector2d other) {
        return this.position.equals(other);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD, BACKWARD -> {
                Vector2d movement = orientation.toUnitVector();
                if (direction == MoveDirection.BACKWARD) {
                    movement = new Vector2d(-movement.getX(), -movement.getY());
                }
                Vector2d newPos = position.add(movement);
                // Zakładamy mapę 5x5
                if (newPos.getX() >= 0 && newPos.getX() <= 4 && newPos.getY() >= 0 && newPos.getY() <= 4) {
                    position = newPos;
                }
            }
        }
    }

    @Override
    public String toString() {
        return position.toString() + " " + orientation.toString();
    }
}
