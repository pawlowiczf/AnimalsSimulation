package agh.ics.oop;
import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;
import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

import static agh.ics.oop.OptionsParser.directionParser;
import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    //
    @Test
    public void doesInputMatchAnimalsMoves() {
        // given
        RectangularMap animalsPark = new RectangularMap(4, 4);
        Vector2d posA = new Vector2d(2,2);
        Vector2d posB = new Vector2d(1,1);
        Vector2d posC = new Vector2d(-1, 1);

        List <Vector2d> positions = new ArrayList<>( Arrays.asList(posA, posB, posC) );

        List <MoveDirection> directions = new ArrayList<>
                (
                Arrays.asList( MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD)
                ) ;

        Simulation simulation = new Simulation(positions, directions, animalsPark);

        // when
        Vector2d newPosA = new Vector2d(2, 2);
        Vector2d newPosB = new Vector2d(0, 2);
        Vector2d newPosC = new Vector2d(-1, 1); // w tym przypadku pozycja nie powinna się zmienić - zwierzę jest poza mapą
        simulation.run();

        List <Vector2d> newPositions = new ArrayList<>( Arrays.asList( newPosA, newPosB, newPosC ) );
        List <Animal> animals = simulation.getAnimalsList();

        // then

        assertEquals( newPosA, animals.get(0).getPosition() );
        assertEquals( newPosB, animals.get(1).getPosition()  );

    }

    @Test
    public void forbidTwoAnimalsToStayOnSameField() {
        // given
        Vector2d posA = new Vector2d(10,10);
        Vector2d posB = new Vector2d(10, 9);
        List <MoveDirection> directions = new ArrayList<>
                (
                Arrays.asList( MoveDirection.RIGHT, MoveDirection.FORWARD)
                );

        RectangularMap animalsPark = new RectangularMap(11, 11);
        List <Vector2d> positions = new ArrayList<>( Arrays.asList(posA, posB) );
        Simulation simulation = new Simulation(positions, directions, animalsPark);

        // when
        Vector2d newPosA = new Vector2d(10, 10);
        Vector2d newPosB = new Vector2d(10, 9);
        simulation.run();

        // then

        // pozycje nie powinny się zmienić
        assertEquals(newPosA, posA);
        assertEquals(newPosB, posB);
    }

    @Test
    public void fullIntegrationTest() {
        // given
        String[] args = {"f", "b", "r", "l", "l", "f", "f", "f", "b", "b"};
        List <MoveDirection> directions = directionParser(args);
        List <Vector2d> startingPositions = new ArrayList<>
                (
                Arrays.asList( new Vector2d(5, 5), new Vector2d(4,1), new Vector2d(6, 8) )
                );

        RectangularMap animalsPark = new RectangularMap(10, 10);
        Simulation simulation = new Simulation(startingPositions, directions, animalsPark);

        // when
        simulation.run();
        Vector2d posA = new Vector2d(5, 6);
        Vector2d posB = new Vector2d(3, 0);
        Vector2d posC = new Vector2d(6, 8);
        List <Vector2d> newPositions = new ArrayList<>( Arrays.asList( posA, posB, posC ) );
        List <Animal> listOfAnimals = simulation.getAnimalsList();

        // then

        // Check, if positions are correct.
        for ( int idx = 0 ; idx < listOfAnimals.size() ; idx++) {
            assertEquals( newPositions.get(idx), listOfAnimals.get(idx).getPosition() );
        }

        // Check, whether orientations are correct.
        assertEquals( MapDirection.WEST, listOfAnimals.get(0).getOrientation() );
        assertEquals( MapDirection.WEST, listOfAnimals.get(1).getOrientation() );
        assertEquals( MapDirection.EAST, listOfAnimals.get(2).getOrientation() );


    }
}