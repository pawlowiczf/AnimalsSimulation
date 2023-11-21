package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation{
    //
    private final List <MoveDirection> directions;
    private final List <Animal> animals = new ArrayList<>();
    private final RectangularMap animalsPark;

    public Simulation(List <Vector2d> positions, List <MoveDirection> directions, RectangularMap animalsPark) {
        this.directions  = directions;
        this.animalsPark = animalsPark;

        for( Vector2d position : positions ) {
            //
            animalsPark.place( new Animal( position.getX(), position.getY() ) );
            this.animals.add(  new Animal( position.getX(), position.getY() ) );
        }
    } // constructor

    // Methods:

    public void run() {
        //
        int numberOfAnimals = this.animals.size();
        int index = 0;

        for( MoveDirection direction : directions ) {
            //
            int currentIndex = index % numberOfAnimals;

            Animal currentAnimal = this.animals.get( currentIndex );
            animalsPark.move( currentAnimal, direction );

            index += 1;
            System.out.println( animalsPark );
        } // end 'for each' loop

    } // end 'run' method

    public List<Animal> getAnimalsList() {
        return animals;
    } // getter for unit-tests

} // end 'Simulation' class
