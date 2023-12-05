package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    //
    private int updateNumber = 1;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        //
        System.out.println(message);
        System.out.println(worldMap);
        System.out.println("Update number: " + updateNumber);
        updateNumber += 1;
    }

}
