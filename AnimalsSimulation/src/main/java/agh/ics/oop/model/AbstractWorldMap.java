package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap{
    //
    protected Map<Vector2d, Animal> animals = new HashMap<>();

    protected AbstractWorldMap() {

    } // default, empty constructor

    protected AbstractWorldMap( Map<Vector2d, Animal> animals) {
        this.animals = animals;
    }

    public void move(Animal animal, MoveDirection direction) {
        //
        if ( animals.containsKey( animal.getPosition() ) ) {
            animals.remove( animal.getPosition() );
            animal.move(direction, this);
            animals.put( animal.getPosition(), animal );
        }
    }

    public boolean place(Animal animal) {
        //
        if ( canMoveTo( animal.getPosition() ) ) {
            animals.put( animal.getPosition(), animal );
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        return this.animals.containsKey(position);
    }

    public boolean canMoveTo(Vector2d position) {
        //
        return !isOccupied(position);
    }


}
