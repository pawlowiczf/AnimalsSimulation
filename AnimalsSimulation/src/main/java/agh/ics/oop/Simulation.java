package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.model.util.PositionAlreadyOccupiedException;

import java.util.ArrayList;
import java.util.List;

public class Simulation implements Runnable {
    //
    private final List <MoveDirection> directions;
    private final List <Animal> animals = new ArrayList<>();
    private final WorldMap animalsPark;

    public Simulation(List <Vector2d> positions, List <MoveDirection> directions, WorldMap animalsPark) {
        this.directions  = directions;
        this.animalsPark = animalsPark;

        for( Vector2d position : positions ) {
            //
            try {
                animalsPark.place( new Animal( position.getX(), position.getY() ) );
                this.animals.add(  new Animal( position.getX(), position.getY() ) );
            } catch (PositionAlreadyOccupiedException exception) {
                System.out.println( "Position (%d, %d) is occupied - the animal wasn't added".formatted( position.getX(), position.getY() ) );
            }

        }
    } // constructor

    // Methods:

    @Override
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
        } // end 'for each' loop

    } // end 'run' method

    public List<Animal> getAnimalsList() {
        return animals;
    } // getter for unit-tests

} // end 'Simulation' class
