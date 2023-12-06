package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.util.RandomPositionGenerator;

public class GrassField extends AbstractWorldMap{
    //
    private final Map <Vector2d, Grass> grassLocation = new HashMap<>();
    private Boundary mapBoundary;

    public GrassField(int numberOfGrassFields) {
        //
        super();
        int borderGrass = (int) Math.sqrt(numberOfGrassFields * 10);

        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(borderGrass, borderGrass, numberOfGrassFields);
        Iterator<Vector2d> positionsIterator = randomPositionGenerator.iterator();

        for (Vector2d grassPosition : randomPositionGenerator) {
            grassLocation.put(grassPosition, new Grass(grassPosition));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        //
        return super.canMoveTo(position);
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        //
        super.move(animal, direction);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grassLocation.containsKey(position);
    }

    @Override
    public ArrayList<WorldElement> getElements() {
        //
        ArrayList <WorldElement> elementsOnMap = new ArrayList<>( super.getElements() );
        elementsOnMap.addAll( grassLocation.values() );

        return elementsOnMap;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        //
        if ( super.isOccupied(position) ) {
            return animals.get( position );
        }

        else if ( grassLocation.containsKey(position) ) {
            return this.grassLocation.get( position );
        }

        return null;
    }

    private Boundary getBorderOfMap() {
        //
        ArrayList <WorldElement> elementsOnMap = getElements();
        Vector2d lowerBorder  = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d upperBorder = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (WorldElement element : elementsOnMap) {
            lowerBorder = lowerBorder.lowerLeft(  element.getPosition() );
            upperBorder = upperBorder.upperRight( element.getPosition() );
        }

        return new Boundary(lowerBorder, upperBorder);
    }

    @Override
    public Boundary getCurrentBounds() {
        return getBorderOfMap();
    }

}
