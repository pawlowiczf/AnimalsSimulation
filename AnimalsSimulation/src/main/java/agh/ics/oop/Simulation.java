package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    //
    List <Vector2d> positions;
    List <MoveDirection> directions;
    List <Animal> animals = new ArrayList<>();

    public Simulation(List <Vector2d> positions, List <MoveDirection> directions) {
        this.positions  = positions;
        this.directions = directions;

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
            currentAnimal.move( direction );

            System.out.println( ("Zwierzę %d : ").formatted( currentIndex ) + animals.get(currentIndex) );
            index += 1;
        } // end 'for' loop

    } // end 'run' method

    public List<Animal> getAnimalsList() {
        return animals;
    } // getter for unit-tests

    // W powyższym zadaniu sprawdza się implementacja listy, z której korzystam. Nie wydaje mi się zasadne, by używać innej.
    // Jedynym zastrzeżeniem może być ciągłe używanie operacji modulo - gdybyśmy mieli cykliczną (zapętloną) link listę,
    // to nie musielibyśmy z tego korzystać, ale coś takiego, tak myślę, wymaga własnej implementacji.


} // end 'Simulation' class
