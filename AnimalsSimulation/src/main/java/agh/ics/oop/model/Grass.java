package agh.ics.oop.model;

public class Grass implements WorldElement{
    //
    Vector2d grassPosition;
    public Grass(Vector2d grassPosition) {
        //
        this.grassPosition = grassPosition;
    }

    @Override
    public Vector2d getPosition() {
        return grassPosition;
    }

    @Override
    public String toString() {
        return "*";
    }
}
