package zse.oop.model;

public class RectangularMap extends AbstractWorldMap {

    private final int width;
    private final int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.getX() >= 0 && position.getX() < width &&
                position.getY() >= 0 && position.getY() < height &&
                !isOccupied(position);
    }

    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(
                new Vector2d(0, 0),
                new Vector2d(width - 1, height - 1)
        );
    }
}
