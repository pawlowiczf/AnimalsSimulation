package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import agh.ics.oop.model.util.PositionAlreadyOccupiedException;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractWorldMap implements WorldMap{
    //
    private final int mapId;
    protected Map<Vector2d, Animal> animals;
    private final MapVisualizer visualizer;
    private final ArrayList <MapChangeListener> subscribers = new ArrayList<>(); // Lista subskrybentów, tj. lista obserwatorów.

    protected AbstractWorldMap(int mapId) {
        this(mapId, new HashMap<>());
    } // empty constructor - jak go nie dodam, to wywala mi błąd w 'GrassField'!

    protected AbstractWorldMap( int mapId, Map<Vector2d, Animal> animals) {
        //
        this.visualizer = new MapVisualizer(this);
        this.animals = animals;
        this.mapId   = mapId;
    } // constructor

    public void move(Animal animal, MoveDirection direction) {
        //
        if ( animals.containsKey( animal.getPosition() ) ) {
            //
            Vector2d oldPosition = animal.getPosition();

            animals.remove( animal.getPosition() );
            animal.move(direction, this);
            animals.put( animal.getPosition(), animal );

            if ( ! animal.getPosition().equals(oldPosition) ) {
                mapChanged( "Animal changed its position from (%d, %d) to (%d, %d)!".formatted( oldPosition.getX(), oldPosition.getY(), animal.getPosition().getX(), animal.getPosition().getY() ));
            }

        } // end 'if' clause
    } // end 'move' method

    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        //
        if ( canMoveTo( animal.getPosition() ) ) {
            animals.put( animal.getPosition(), animal );
            mapChanged( "Animal was added to the map!" );
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

    private void mapChanged(String message) {
        //
        for( MapChangeListener subscriber : subscribers ) {
            subscriber.mapChanged(this, message);
        }
    }

    public void addSubscriber(MapChangeListener subscriber) {
        this.subscribers.add( subscriber );
    }

    public void removeSubscriber(MapChangeListener subscriber) {
        this.subscribers.remove( subscriber );
    }

    @Override
    public int getId() {
        return this.mapId;
    }

    @Override
    public List <Animal> getOrderedAnimals() {
        //
        ArrayList <Vector2d> animalsPositions = new ArrayList<>( this.animals.keySet() );

        // Klasa Vector2d realizuje interfejs Comparable;
        Collections.sort( animalsPositions );

        return animalsPositions.stream()
                .map( position -> animals.get(position) )
                .collect( Collectors.toList() );

    } // end method getOrderedAnimals()

}
