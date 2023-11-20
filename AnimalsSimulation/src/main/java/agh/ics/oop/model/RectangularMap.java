package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    //
    private int width;
    private int height;
    private Map <Vector2d, Animal> animals = new HashMap<>();

    public RectangularMap(int width, int height) {
        this.width  = width;
        this.height = height;
    } // constructor

    @Override
    public void move(Animal animal, MoveDirection direction) {
        //
        Vector2d oldPosition = animal.getPosition();

        if ( this.animals.containsValue( animal ) ) {
            animal.move(direction);

            if ( this.animals.containsKey( animal.getPosition() ) ) {

            }
        }
    }
    @Override
    public boolean place(Animal animal) {
        //
        if ( this.animals.containsKey( animal.getPosition() ) ) {
            return false;
        }

        this.animals.put( animal.getPosition(), animal );
        return true;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        //
        return position.precedes( new Vector2d(width, height) ) && position.follow( new Vector2d(0, 0) );
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        //
        if ( isOccupied(position) ) {
            return this.animals.get( position );
        }
        return null;
    }

}
