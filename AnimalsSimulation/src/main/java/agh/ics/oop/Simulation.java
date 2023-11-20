package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    //
    private List <MoveDirection> directions;
    private List <Animal> animals = new ArrayList<>();
    private WorldMap animalsPark;

    public Simulation(List <Vector2d> positions, List <MoveDirection> directions, WorldMap animalsPark) {
        this.directions  = directions;
        this.animalsPark = animalsPark;
        for( Vector2d position : positions ) {
            //
            this.animals.add( new Animal( position.getX(), position.getY() ) );
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
            currentAnimal.move( direction, animalsPark );

            System.out.println( ("Zwierzę %d : ").formatted( currentIndex ) + animals.get(currentIndex) );
            index += 1;
        } // end 'for' loop

    } // end 'run' method

    public List<Animal> getAnimalsList() {
        return animals;
    } // getter for unit-tests

} // end 'Simulation' class
