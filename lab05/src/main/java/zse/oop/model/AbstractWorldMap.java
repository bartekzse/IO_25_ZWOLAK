package zse.oop.model;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    // przechowujemy tylko zwierzęta i trawy osobno
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final Map<Vector2d, Grass> grasses = new HashMap<>();
    protected final MapVisualizer visualizer = new MapVisualizer(this);

    /**
     * Implementacja, którą można współdzielić: place zwierzęcia.
     */
    @Override
    public boolean place(Animal animal) {
        Vector2d pos = animal.getPosition();
        if (canMoveTo(pos) && !animals.containsKey(pos)) {
            animals.put(pos, animal);
            animal.setMap(this); // Animal używa MoveValidator - WorldMap jest jego subtypem
            return true;
        }
        return false;
    }

    /**
     * Ruch zwierzęcia — aktualizuje mapę zwierząt.
     */
    @Override
    public void move(Animal animal, Direction direction) {
        if (!animals.containsKey(animal.getPosition())) return;

        Vector2d oldPos = animal.getPosition();
        animal.move(direction); // animal sprawdza map.canMoveTo()
        Vector2d newPos = animal.getPosition();

        if (!oldPos.equals(newPos)) {
            animals.remove(oldPos);
            animals.put(newPos, animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        // priorytet zwierząt nad trawą
        return animals.containsKey(position) || grasses.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.containsKey(position)) return animals.get(position);
        if (grasses.containsKey(position)) return grasses.get(position);
        return null;
    }

    @Override
    public java.util.Collection<WorldElement> getElements() {
        List<WorldElement> result = new ArrayList<>();
        result.addAll(animals.values());
        result.addAll(grasses.values());
        return Collections.unmodifiableList(result);
    }

    /**
     * Domyślna implementacja toString() wykorzystuje MapVisualizer i zakres
     * wyliczony na podstawie elementów (zwierząt + trawy).
     */
    @Override
    public String toString() {
        Vector2d lowerLeft = calculateLowerLeft();
        Vector2d upperRight = calculateUpperRight();
        return visualizer.draw(lowerLeft, upperRight);
    }

    /**
     * Oblicza minimalny punkt (lower-left) biorąc pod uwagę zwierzęta i trawę.
     * Jeśli brak elementów — zwraca (0,0).
     */
    protected Vector2d calculateLowerLeft() {
        if (animals.isEmpty() && grasses.isEmpty()) return new Vector2d(0, 0);

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (WorldElement e : getElements()) {
            Vector2d p = e.getPosition();
            if (p.getX() < minX) minX = p.getX();
            if (p.getY() < minY) minY = p.getY();
        }
        return new Vector2d(minX, minY);
    }

    /**
     * Oblicza upper-right. Jeśli brak elementów — (0,0).
     */
    protected Vector2d calculateUpperRight() {
        if (animals.isEmpty() && grasses.isEmpty()) return new Vector2d(0, 0);

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (WorldElement e : getElements()) {
            Vector2d p = e.getPosition();
            if (p.getX() > maxX) maxX = p.getX();
            if (p.getY() > maxY) maxY = p.getY();
        }
        return new Vector2d(maxX, maxY);
    }

    /**
     * Pozwala implementacjom dodać trawę (użyte w GrassField).
     */
    protected boolean placeGrass(Grass grass) {
        Vector2d pos = grass.getPosition();
        if (!grasses.containsKey(pos) && !animals.containsKey(pos)) {
            grasses.put(pos, grass);
            return true;
        }
        return false;
    }
}
