package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import static agh.ics.oop.OptionsParser.directionParser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    public void doesDirectionParserWork() {
        //given
        String[] argumentsA = {"f", "X", "K", "r", "l"};
        String[] argumentsB = {};
        String[] argumentsC = {"0", "NIE MAM", "HEJKA", "FLP", "GRY"};

        //when
        MoveDirection[] directionsA = directionParser(argumentsA);
        MoveDirection[] properDirectionsA = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.LEFT};

        MoveDirection[] directionsB = directionParser(argumentsB);
        MoveDirection[] properDirectionsB = {};

        MoveDirection[] directionsC = directionParser(argumentsC);
        MoveDirection[] properDirectionsC = {};

        //then
        assertArrayEquals(directionsA, properDirectionsA);
        assertArrayEquals(directionsB, properDirectionsB);
        assertArrayEquals(directionsC, properDirectionsC);

    }
}