package zse.oop;

import zse.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Direction> moves;
    private final WorldMap map; // ✅ było RectangularMap

    public Simulation(WorldMap map, List<Direction> moves, List<Vector2d> positions) { // ✅
        this.map = map;
        this.moves = moves;

        for (Vector2d pos : positions) {
            Animal animal = new Animal(pos);
            animal.setMap(map);
            animals.add(animal);
            map.place(animal);
        }
    }

    public void run() {
        int animalCount = animals.size();
        for (int i = 0; i < moves.size(); i++) {
            Animal currentAnimal = animals.get(i % animalCount);
            Direction move = moves.get(i);

            map.move(currentAnimal, move);
            System.out.println("Po ruchu " + (i + 1) + ":");
            System.out.println(map);
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
