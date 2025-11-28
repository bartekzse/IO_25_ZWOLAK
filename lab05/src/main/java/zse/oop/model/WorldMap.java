package zse.oop.model;

import zse.oop.model.Vector2d;

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo, idzik
 */
public interface WorldMap extends MoveValidator {

    /**
     * Place a animal on the map.
     *
     * @param animal The animal to place on the map.
     * @return True if the animal was placed. The animal cannot be placed if the move is not valid.
     */
    boolean place(Animal animal);

    /**
     * Moves an animal (if it is present on the map) according to specified direction.
     * If the move is not possible, this method has no effect.
     */
    void move(Animal animal, Direction direction);

    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position Position to check.
     * @return True if the position is occupied.
     */
    boolean isOccupied(Vector2d position);

    /**
     * Return an element at a given position (animal or grass).
     *
     * @param position The position to check.
     * @return WorldElement or null if the position is not occupied.
     */
    WorldElement objectAt(Vector2d position);

    /**
     * Zwraca kolekcję wszystkich elementów (zwierząt i roślin) znajdujących się na mapie.
     */
    java.util.Collection<WorldElement> getElements();
}
