package zse.oop.model;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {

    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final Map<Vector2d, Grass> grasses = new HashMap<>();

    private final List<MapChangeListener> listeners = new ArrayList<>();
    protected final MapVisualizer visualizer = new MapVisualizer(this);

    @Override
    public boolean place(Animal animal) throws PositionAlreadyOccupiedException {
        Vector2d pos = animal.getPosition();

        if (animals.containsKey(pos) || !canMoveTo(pos))
            throw new PositionAlreadyOccupiedException(pos);

        grasses.remove(pos);
        animals.put(pos, animal);
        animal.setMap(this);

        mapChanged("Animal placed at " + pos);
        return true;
    }

    @Override
    public void move(Animal animal, Direction direction) {
        Vector2d oldPos = animal.getPosition();
        animal.move(direction);
        Vector2d newPos = animal.getPosition();

        if (!oldPos.equals(newPos)) {
            animals.remove(oldPos);

            if (!animals.containsKey(newPos)) {
                animals.put(newPos, animal);
                grasses.remove(newPos);

                mapChanged("Animal moved from " + oldPos + " to " + newPos);
            } else {
                // collision → return
                animal.setPosition(oldPos);
                animals.put(oldPos, animal);
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position) || grasses.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.containsKey(position)) return animals.get(position);
        return grasses.get(position);
    }

    @Override
    public Collection<WorldElement> getElements() {
        List<WorldElement> list = new ArrayList<>();
        list.addAll(animals.values());
        list.addAll(grasses.values());
        return Collections.unmodifiableList(list);
    }

    // === OBSERVER MECHANISM ===
    public void addListener(MapChangeListener listener) {
        listeners.add(listener);
    }

    public void removeListener(MapChangeListener listener) {
        listeners.remove(listener);
    }

    protected void mapChanged(String message) {
        for (MapChangeListener l : listeners)
            l.mapChanged(this, message);
    }

    // === TEMPLATE METHOD ===
    @Override
    public String toString() {
        Boundary bounds = getCurrentBounds();
        return visualizer.draw(bounds.lowerLeft(), bounds.upperRight());
    }
}
