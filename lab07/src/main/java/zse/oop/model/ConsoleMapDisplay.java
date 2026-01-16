package zse.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {

    private int updateCount = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        updateCount++;
        System.out.println("MAP UPDATE #" + updateCount + " [Map ID: " + worldMap.getId() + "]");
        System.out.println(message);
        System.out.println(worldMap.toString());
    }
}
