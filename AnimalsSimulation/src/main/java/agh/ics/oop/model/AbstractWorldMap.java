package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.util.PositionAlreadyOccupiedException;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap{
    //
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    private MapVisualizer visualizer;
    protected AbstractWorldMap() {

    } // empty constructor - jak go nie dodam to wywala mi błąd w GrassField!
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

    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        //
        if ( canMoveTo( animal.getPosition() ) ) {
            animals.put( animal.getPosition(), animal );
        }
        else {
            throw new PositionAlreadyOccupiedException( animal.getPosition() );
        }
    }

    public boolean isOccupied(Vector2d position) {
        return this.animals.containsKey(position);
    }

    public boolean canMoveTo(Vector2d position) {
        //
        return !isOccupied(position);
    }

    public ArrayList<WorldElement> getElements() {
        return new ArrayList <> ( animals.values() );
    }

    public abstract Boundary getCurrentBounds();

    @Override
    public String toString() {
        Boundary mapBorder = getCurrentBounds();
        return visualizer.draw( mapBorder.leftBorder(), mapBorder.rightBorder() );
    }
}
