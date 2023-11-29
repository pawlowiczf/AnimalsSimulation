package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;
import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {
    //
    private final int width;
    private final int height;

    public RectangularMap(int width, int height) {
        super();
        this.width  = width;
        this.height = height;
    } // constructor


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
        if ( super.canMoveTo(position) ){
            return position.precedes( new Vector2d(width, height) ) && position.follow( new Vector2d(0, 0) );
        }
        return false;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position);
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

    public Boundary getCurrentBounds() {
        //
        return new Boundary( new Vector2d(0,0), new Vector2d(width, height) );
    }

    public Map<Vector2d, Animal> getAnimals() {
        return animals;
    }
}
