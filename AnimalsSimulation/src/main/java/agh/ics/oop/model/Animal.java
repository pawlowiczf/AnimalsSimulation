package agh.ics.oop.model;

public class Animal {
    //
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public Animal() {

    }
    public Animal(int x, int y) {
        //
        this.position = new Vector2d(x, y);
    }

    @Override
    public String toString() {
        return "orientation = " + orientation + ", position = " + position;
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
                    if ( position.precedes( new Vector2d(4,4) ) )
                        this.position = position.add( orientation.toUnitVector() );
            }

            case BACKWARD -> {
                    if ( position.follow( new Vector2d(-4, -4) ) )
                        position.subtract( orientation.toUnitVector() );
            }
        };
    }

}

