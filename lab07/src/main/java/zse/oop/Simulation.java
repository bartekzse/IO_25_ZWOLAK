package zse.oop;

import zse.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<Animal> animals = new ArrayList<>();
    private final List<Direction> moves;
    private final WorldMap map;

    public Simulation(WorldMap map, List<Direction> moves, List<Vector2d> positions) {
        this.map = map;
        this.moves = moves;

        for (Vector2d pos : positions) {
            Animal animal = new Animal(pos);
            try {
                map.place(animal);
                animals.add(animal);
            } catch (PositionAlreadyOccupiedException e) {
                System.out.println("Nie udało się ustawić zwierzęcia: " + e.getMessage());
            }
        }
    }

    public void run() {
        if (animals.isEmpty()) return;
        int n = animals.size();
        for (int i = 0; i < moves.size(); i++) {
            Animal current = animals.get(i % n);
            map.move(current, moves.get(i));
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
