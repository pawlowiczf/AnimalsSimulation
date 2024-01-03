package agh.ics.oop.model;

import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static agh.ics.oop.OptionsParser.directionParser;
import static org.junit.jupiter.api.Assertions.*;

class AbstractWorldMapTest {

    @Test
    void doesGetOrderedAnimalsWork() {
        // given
        List <MoveDirection> directions = List.of( MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD );
        List <Vector2d> positions = List.of( new Vector2d(2, 2 ), new Vector2d(3, 2 ), new Vector2d(0,0  ) );

        GrassField animalsPark = new GrassField(1, 10);
        Simulation simulation = new Simulation(positions, directions, animalsPark);

        // when
        List <Animal> orderedAnimalsA = animalsPark.getOrderedAnimals();
        List <Vector2d> orderedPositions = List.of( new Vector2d(0,0  ), new Vector2d(2, 2 ), new Vector2d(3, 2 ) );

        // then
        assertEquals( orderedPositions.get(0).getX(), orderedAnimalsA.get(0).getPosition().getX() );
        assertEquals( orderedPositions.get(0).getY(), orderedAnimalsA.get(0).getPosition().getY() );

        assertEquals( orderedPositions.get(1).getX(), orderedAnimalsA.get(1).getPosition().getX() );
        assertEquals( orderedPositions.get(1).getY(), orderedAnimalsA.get(1).getPosition().getY() );

        assertEquals( orderedPositions.get(2).getX(), orderedAnimalsA.get(2).getPosition().getX() );
        assertEquals( orderedPositions.get(2).getY(), orderedAnimalsA.get(2).getPosition().getY() );

    }
}

