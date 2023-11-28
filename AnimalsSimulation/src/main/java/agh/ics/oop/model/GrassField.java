package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.util.RandomPositionGenerator;

public class GrassField extends AbstractWorldMap{
    //
    private final int numberOfGrassFields;
    private final Map <Vector2d, Grass> grassLocation = new HashMap<>();

    int yMax, yMin, xMax, xMin;

    public GrassField(int numberOfGrassFields) {
        //
        super();
        this.numberOfGrassFields = numberOfGrassFields;

        int borderGrass = (int) Math.sqrt( numberOfGrassFields * 10 );
        yMax = xMax = borderGrass;
        yMin = xMin = -borderGrass;

        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(borderGrass, borderGrass, numberOfGrassFields);
        Iterator<Vector2d> positionsIterator = randomPositionGenerator.iterator();

        for(Vector2d grassPosition : randomPositionGenerator) {
            grassLocation.put(grassPosition, new Grass(grassPosition));
        }

        // Stara naiwna-wersja generowania pozycji trawy:
//        int grassPutOnMap = 0;
//
//        while (grassPutOnMap < numberOfGrassFields ) {
//            //
//            int randomX = (int) Math.floor( Math.random() * ( borderGrass + 1) );
//            int randomY = (int) Math.floor( Math.random() * ( borderGrass + 1) );
//            Vector2d newGrassLocation = new Vector2d(randomX, randomY);
//
//            if ( !grassLocation.containsKey( newGrassLocation ) )  {
//                grassLocation.put( newGrassLocation, new Grass( newGrassLocation ) );
//                updateBorderOfMap(newGrassLocation);
//                grassPutOnMap++;
//            }
//        } // end 'while' loop

    } // constructor

    private void updateBorderOfMap(Vector2d locationOfObject) {
        //
        this.yMax = Math.max( yMax, locationOfObject.getY() );
        this.yMin = Math.min( yMin, locationOfObject.getY() );
        this.xMax = Math.max( xMax, locationOfObject.getX() );
        this.xMin = Math.min( xMin, locationOfObject.getX() );
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        //
        return super.canMoveTo(position);
    }

    @Override
    public boolean place(Animal animal) {
        //
        if ( super.place(animal) ) {
            updateBorderOfMap( animal.getPosition() );
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        //
        super.move(animal, direction);
        updateBorderOfMap( animal.getPosition() );
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grassLocation.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        //
        if ( super.isOccupied(position) ) {
            return this.animals.get( position );
        }

        else if ( grassLocation.containsKey(position) ) {
            return this.grassLocation.get( position );
        }

        return null;
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw( new Vector2d(xMin, yMin), new Vector2d(xMax, yMax) );
    }
}
