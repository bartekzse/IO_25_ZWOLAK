package zse.oop.model;

import java.util.List;

public class Simulation {

    private final List<MoveDirection> moves;
    private final List<Animal> animals;
    private final WorldMap map;

    public Simulation(List<MoveDirection> moves, List<Animal> animals, WorldMap map) {
        this.moves = moves;
        this.animals = animals;
        this.map = map;
    }

    public void run() {
        System.out.println(map.toString());
        int i = 0;
        for (MoveDirection move : moves) {
            Animal currentAnimal = animals.get(i % animals.size());
            map.move(currentAnimal, move);
            System.out.println(map.toString());
            i++;
        }
    }
}
