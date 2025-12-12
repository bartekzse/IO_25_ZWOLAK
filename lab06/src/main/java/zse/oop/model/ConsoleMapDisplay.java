package zse.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {

    private int updateCount = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        updateCount++;
        System.out.println("MAP UPDATE #" + updateCount);
        System.out.println(message);
        System.out.println(worldMap.toString());
    }
}
