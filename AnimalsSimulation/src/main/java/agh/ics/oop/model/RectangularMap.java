package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;
import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    //
    private final int width;
    private final int height;
    private final Map <Vector2d, Animal> animals = new HashMap<>();

    public RectangularMap(int width, int height) {
        this.width  = width;
        this.height = height;
    } // constructor

    @Override
    public void move(Animal animal, MoveDirection direction) {
        //
        if ( animals.containsKey( animal.getPosition() ) ) {
            // sytuacja, gdy zwierzę jest na mapie
            animals.remove( animal.getPosition() );
            animal.move(direction, this);
            animals.put( animal.getPosition(), animal );
        }


    }
    @Override
    public boolean place(Animal animal) {
        //
        if ( this.canMoveTo( animal.getPosition() ) ) {
            animals.put( animal.getPosition(), animal );
            return true;
        }

        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        //
        if ( isOccupied(position) ) { return false; }

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

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Vector2d(0, 0), new Vector2d(width, height) );
    }
}
