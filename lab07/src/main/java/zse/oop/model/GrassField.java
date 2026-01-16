package zse.oop.model;

import java.util.Random;

public class GrassField extends AbstractWorldMap {

    private final int grassCount;
    private final Random random;

    public GrassField(int grassCount) {
        this(grassCount, new Random());
    }

    public GrassField(int grassCount, Random random) {
        this.grassCount = grassCount;
        this.random = random;
        generateGrass();
    }

    private void generateGrass() {
        int area = (int) Math.ceil(Math.sqrt(grassCount * 9));
        while (grasses.size() < grassCount) {
            int x = random.nextInt(area + 1);
            int y = random.nextInt(area + 1);

            Vector2d pos = new Vector2d(x, y);
            if (isOccupied(pos)) continue;

            grasses.put(pos, new Grass(pos));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public Boundary getCurrentBounds() {
        if (animals.isEmpty() && grasses.isEmpty())
            return new Boundary(new Vector2d(0, 0), new Vector2d(0, 0));

        Vector2d lower = null;
        Vector2d upper = null;

        for (WorldElement e : getElements()) {
            if (lower == null) {
                lower = e.getPosition();
                upper = e.getPosition();
            } else {
                lower = lower.lowerLeft(e.getPosition());
                upper = upper.upperRight(e.getPosition());
            }
        }
        return new Boundary(lower, upper);
    }
}
