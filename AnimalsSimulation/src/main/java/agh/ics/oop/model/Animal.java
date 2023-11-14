package agh.ics.oop.model;

import java.util.Vector;

public class Animal {
    //
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public Animal() {

    } // default constructor

    public Animal(int x, int y) {
        //
        this.position = new Vector2d(x, y);
    } // constructor


    // Methods:

    @Override
    public String toString() {
        return orientation + " " + position;
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        //
        switch(direction) {
            case RIGHT    -> orientation = orientation.next();
            case LEFT     -> orientation = orientation.previous();

            case FORWARD  -> {
                if ( position.add( orientation.toUnitVector() ).precedes( new Vector2d(4,4)    ) &&
                     position.add( orientation.toUnitVector() ).follow(   new Vector2d(0, 0) ) )
                {
                    position = this.position.add( orientation.toUnitVector() );
                }

            }

            case BACKWARD -> {
                if ( position.subtract( orientation.toUnitVector() ).follow(   new Vector2d(0, 0) ) &&
                     position.subtract( orientation.toUnitVector() ).precedes( new Vector2d(4,4)    ) )
                {
                    position = this.position.subtract( orientation.toUnitVector() );
                }

            }
        };
    } // end 'move' method

    public MapDirection getOrientation() {
        return this.orientation;
    } // getter for unit-tests
    public Vector2d getPosition() { return this.position; }

} // end 'Animal' class

