package agh.ics.oop.model;

public class TestingClasses {

    public static void main(String[] args) {

        Animal animalA = new Animal(2,2);
        System.out.println( animalA );

        animalA.move(MoveDirection.FORWARD);
        System.out.println( animalA );

        animalA.move(MoveDirection.FORWARD);
        System.out.println( animalA );

        animalA.move(MoveDirection.RIGHT);
        System.out.println( animalA );

        animalA.move(MoveDirection.FORWARD);
        System.out.println( animalA );

        animalA.move(MoveDirection.FORWARD);
        System.out.println( animalA );

        animalA.move(MoveDirection.FORWARD);
        System.out.println( animalA );
    }
}
