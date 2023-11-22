package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    //
    private final List <MoveDirection> directions;
    private final List <Animal> animals = new ArrayList<>();
    private final WorldMap animalsPark;

    public Simulation(List <Vector2d> positions, List <MoveDirection> directions, WorldMap animalsPark) {
        this.directions  = directions;
        this.animalsPark = animalsPark;

        for( Vector2d position : positions ) {
            //
            if ( animalsPark.place( new Animal( position.getX(), position.getY() ) ) ) {
                this.animals.add(  new Animal( position.getX(), position.getY() ) );
            }
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
