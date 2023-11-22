package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class GrassField implements WorldMap {
    //
    private final int numberOfGrassFields;
    private final Map <Vector2d, Grass> grassLocation = new HashMap<>();
    private final Map <Vector2d, Animal> animals = new HashMap<>();

    public GrassField(int numberOfGrassFields) {
        this.numberOfGrassFields = numberOfGrassFields;

        int borderGrass = (int) Math.sqrt( numberOfGrassFields * 10 );
        int grassPutOnMap = 0;

        while (grassPutOnMap < numberOfGrassFields ) {
            //
            int randomX = (int) Math.floor( Math.random() * ( borderGrass + 1) );
            int randomY = (int) Math.floor( Math.random() * ( borderGrass + 1) );
            Vector2d newGrassLocation = new Vector2d(randomX, randomY);

            if ( !grassLocation.containsKey( newGrassLocation ) )  {
                grassLocation.put( newGrassLocation, new Grass( newGrassLocation ) );
                grassPutOnMap++;
            }
        } // end 'while' loop
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        //
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        //
        if ( canMoveTo( animal.getPosition() ) ) {
            animals.put( animal.getPosition(), animal );
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        //
        if ( animals.containsKey( animal.getPosition() ) ) {
            animals.remove( animal.getPosition() );
            animal.move(direction, this);
            animals.put( animal.getPosition(), animal );
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        //
        if ( isOccupied(position) ) {
            return this.animals.get( position );
        }
        return null;
    }
    //

}
