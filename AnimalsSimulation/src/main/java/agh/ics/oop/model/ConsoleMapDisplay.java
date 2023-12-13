package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    //
    private int updateNumber = 1;

    @Override
    public synchronized void mapChanged(WorldMap worldMap, String message) {
        //
        System.out.println( "Map id: " + worldMap.getId() );
        System.out.println(message);
        System.out.println(worldMap);
        System.out.println("Update number: " + updateNumber);
        System.out.println("-----------------------------------------------");
        updateNumber += 1;
    }

}
