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
        return switch(orientation) {
            case NORTH -> "N";
            case EAST  -> "E";
            case SOUTH -> "S";
            case WEST  -> "W";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator <Vector2d> validator) {
        //
        switch(direction) {
            case RIGHT    -> orientation = orientation.next();
            case LEFT     -> orientation = orientation.previous();

            case FORWARD  -> {
                if ( validator.canMoveTo( position.add( orientation.toUnitVector() ) ) )
                {
                    position = this.position.add( orientation.toUnitVector() );
                }

            }

            case BACKWARD -> {
                if ( validator.canMoveTo(position.subtract( orientation.toUnitVector() ) ) )
                {
                    position = this.position.subtract( orientation.toUnitVector() );
                }

            }
        };
    } // end 'move' method

    public MapDirection getOrientation() {
        return this.orientation;
    } // getter for unit-tests

    public Vector2d getPosition() {
        return position;
    }
} // end 'Animal' class

