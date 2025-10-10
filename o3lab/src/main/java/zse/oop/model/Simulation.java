package zse.oop.model;

import java.util.*;

public class Simulation {
    private final List<Animal> animals = new ArrayList<>();
    private final List<MoveDirection> directions;

    public Simulation(List<MoveDirection> directions, List<Vector2d> positions) {
        this.directions = directions;
        for (Vector2d pos : positions) {
            animals.add(new Animal(pos));
        }
    }

    public void run() {
        int n = animals.size();
        for (int i = 0; i < directions.size(); i++) {
            Animal current = animals.get(i % n);
            current.move(directions.get(i));
            System.out.println("Zwierze " + (i % n) + ": " + current);
        }
    }
}
